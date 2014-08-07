package ro.generic.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements a generic job/task scheduler used to handle all the
 * various jobs in an unifed way
 *
 * @author Ion Badita (yonic)
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 3, 2004
 */
public class JobScheduler {

	//---------------------------------------------------------//
	//                        CONSTANTS                        //
	//---------------------------------------------------------//

	private static final String PARAM_CLASS = "class";
	private static final String PARAM_NAME = "name";
	private static final String PARAM_FLAGS = "flags";
	private static final String PARAM_DATE = "date";
	private static final String PARAM_COUNT = "count";
	private static final String PARAM_PERFORM = "perform";

	private static final String VALUE_PERFORM_SECONDLY = "secondly";
	private static final String VALUE_PERFORM_MINUTELY = "minutely";
	private static final String VALUE_PERFORM_HOURLY = "hourly";
	private static final String VALUE_PERFORM_DAILY = "daily";
	private static final String VALUE_PERFORM_WEEKLY = "weekly";

	private static final Pattern VARIABLES_PATTERN = Pattern.compile("([\\w]+)=([^=&]+)&*");
	private static final Pattern TIME_DATE_PATTERN = Pattern.compile("([0-9]{1,2})[^0-9]*");
	private static final Pattern FLAGS_PATTERN = Pattern.compile("([\\w]+)\\|*");

	//---------------------------------------------------------//
	//                         STATIC FIELDS                   //
	//---------------------------------------------------------//

	private static JobScheduler instance;

	//---------------------------------------------------------//
	//                          FIELDS                         //
	//---------------------------------------------------------//

	private Timer timer; // internal timer
	private ArrayList jobs; // registered jobs

	//---------------------------------------------------------//
	//                      CONSTRUCTORS                       //
	//---------------------------------------------------------//

	/**
	 * Defalt constructor uised to initialize internal structures
	 */
	public JobScheduler () {
		jobs = new ArrayList();
		// automatically start the scheduler
		startScheduler();
	}

	//---------------------------------------------------------//
	//                         METHODS                         //
	//---------------------------------------------------------//

	/**
	 * Register a new job in the scheduler , double registration is avoided
	 *
	 * @param job to register
	 * @return <i>true</i> if registered otherwise <i>false</i> (already registered or null job)
	 */
	public synchronized boolean addJob (Job job) {
		boolean added = false;
		if (job != null && !jobs.contains(job)) {
			//System.out.println("+ Job " + job.getName());
			job.setScheduler(this);
			added = jobs.add(job);
			timer.scheduleAtFixedRate(job.getTask(), job.getStartDelay(), job.getDelay());
		}
		return added;
	}

	/**
	 * Unregister and cancel a job from the scheduler
	 *
	 * @param job to unregister
	 * @return <i>true</i> if unregistered otherwise <i>false</i> (not found or null job)
	 */
	public synchronized boolean removeJob (Job job) {
		boolean removed = false;
		if ((job != null) && jobs.contains(job)) {
			//System.out.println("- Job " + job.getName());
			job.cancel();
			removed = jobs.remove(job);
			job.setScheduler(null);
		}
		return removed;
	}

	/**
	 * Register a list of jobs
	 *
	 * @param jobs list of strings with job representation
	 */
	public void addJobs (List jobs) {
		for (Iterator i = jobs.iterator(); i.hasNext();) {
			try {
				addJob(createJob((String)i.next()));
			} catch (JobException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Return number of currently registerd jobs
	 *
	 * @return number of registered jobs
	 */
	public int getJobsCount () {
		return jobs.size();
	}

	/**
	 * Return job list as an iterator
	 *
	 * @return current job list
	 */
	public Iterator getJobs () {
		return jobs.iterator();
	}

	/**
	 * Stop the scheduler, and remove and cancel all jobs
	 */
	public void startScheduler () {
		if (timer == null) {
			// timer is created as a daemon
			timer = new Timer(true);
		}
	}

	/**
	 * Stop the scheduler, and remove and cancel all jobs
	 */
	public void stopScheduler () {
		for (Iterator iter = jobs.iterator(); iter.hasNext();) {
			Job job = (Job)iter.next();
			job.cancel();
			iter.remove();
		}
		//cancel the timer
		timer.cancel();
		// nullify the timer (to be restarted if necessry)
		timer = null;
	}

	//---------------------------------------------------------//
	//                         STATIC METHODS                  //
	//---------------------------------------------------------//

	/**
	 * Return the default instance of job scheduler
	 *
	 * @return default job scheduler
	 */
	public static synchronized final JobScheduler getInstance () {
		if (instance == null) {
			instance = new JobScheduler();
		}
		return instance;
	}

	/**
	 * Utility method that generate a Job object from the job scring representation
	 *
	 * @param jobString string representation of the job
	 * @return new created Job object
	 * @throws JobException exception describing why the job could not be created
	 */
	public static final Job createJob (String jobString) throws JobException {
		Job job = null;
		if (jobString != null && jobString.length() > 0) {
			Map params = parseParameters(jobString);
			String className = (String)params.get(PARAM_CLASS);
			if (className == null || className.length() == 0) {
				throw new JobException("Missing class parameter.");
			}
			try {
				Object o = Class.forName(className).newInstance();
				if (o instanceof Job) {
					job = (Job)o;
					String name = (String)params.get(PARAM_NAME);
					Date date = parseDate((String)params.get(PARAM_DATE));
					long perform = parsePerform((String)params.get(PARAM_PERFORM));
					int count = NumberUtil.parseInt((String)params.get(PARAM_COUNT), Job.RUN_FOREVER);
					int flags = parseFlags((String)params.get(PARAM_FLAGS));
					job.initJob(name, date, perform, count, flags);
				} else {
					throw new JobException(className + " is not instance of " + Job.class.getName());
				}
			} catch (JobException e) {
				throw e;
			} catch (ClassNotFoundException e) {
				throw new JobException("Job class not found: " + className);
			} catch (InstantiationException e) {
				throw new JobException("Can't instantiate class: " + className + ", possible reason: no default constructor.", e);
			} catch (Throwable e) {
				throw new JobException("Can't create job: " + className + ", reason: " + e.toString(), e);
			}
		}
		return job;
	}

	/**
	 * Utility method used to parse internal job data represention
	 *
	 * @param dateString job date string
	 * @return a real Date
	 */
	private static final Date parseDate (String dateString) {
		Calendar calendar = Calendar.getInstance();
		if ((dateString != null) && (dateString.length() > 0)) {
			Matcher matcher = TIME_DATE_PATTERN.matcher(dateString);
			int value;
			for (int i = 0; matcher.find(); i++) {
				value = NumberUtil.parseInt(matcher.group(1), 0);
				switch (i) {
					case 0:
						calendar.set(Calendar.HOUR_OF_DAY, value);
						break;
					case 1:
						calendar.set(Calendar.MINUTE, value);
						break;
					case 2:
						calendar.set(Calendar.SECOND, value);
						break;
					case 3:
						calendar.set(Calendar.DAY_OF_MONTH, value);
						break;
					case 4:
						calendar.set(Calendar.MONTH, value - 1);
						break;
						//case 5:
						//	calendar.set(Calendar.YEAR, value);
						//  break;
				}
			}
		}
		return calendar.getTime();
	}

	/**
	 * Internal utility method used to parse a job flags definition
	 *
	 * @param flagsString string to parse
	 * @return specific flags
	 */
	private static final int parseFlags (String flagsString) {
		int flags = 0;
		if ((flagsString != null) && (flagsString.length() > 0)) {
			Matcher matcher = FLAGS_PATTERN.matcher(flagsString.toLowerCase());
			String flag;
			while (matcher.find()) {
				flag = matcher.group(1);
				if (flag.equals("thread")) {
					flags |= Job.FLAG_THREAD;

				} else if (flag.equals("cancel")) {
					flags |= Job.FLAG_CANCEL;
				}
			}
		}
		return flags;
	}

	/**
	 * Internal utility method used to parse a a job perform definition
	 *
	 * @param performString string to be parsed
	 * @return perform mode
	 */
	private static final long parsePerform (String performString) {
		long perform = Job.DEFAULT_PERFORM;

		if ((performString != null) && (performString.length() > 0)) {

			if (performString.equals(VALUE_PERFORM_SECONDLY)) {
				perform = Job.SECONDLY;

			} else if (performString.equals(VALUE_PERFORM_MINUTELY)) {
				perform = Job.MINUTELY;

			} else if (performString.equals(VALUE_PERFORM_HOURLY)) {
				perform = Job.HOURLY;

			} else if (performString.equals(VALUE_PERFORM_DAILY)) {
				perform = Job.DAILY;

			} else if (performString.equals(VALUE_PERFORM_WEEKLY)) {
				perform = Job.WEEKLY;

			} else {
				perform = NumberUtil.parseLong(performString, Job.MINUTELY);
			}
		}
		return perform;
	}

	/**
	 * Internal utility method used to parse a job string
	 *
	 * @param params string to be parsed
	 * @return map with all parameters/values
	 */
	private static final Map parseParameters (String params) {
		HashMap map = null;
		if ((params != null) && (params.length() > 0)) {
			Matcher matcher = VARIABLES_PATTERN.matcher(params);
			map = new HashMap();
			while (matcher.find()) {
				map.put(matcher.group(1), matcher.group(2));
			}
		}
		return map;
	}

	//---------------------------------------------------------//
	//                      INNER CLASSES                      //
	//---------------------------------------------------------//

	/**
	 * Exception class used to wrap Job related exceptions
	 */
	public static class JobException extends Exception {

		/**
		 * Constructor used to set exception message
		 *
		 * @param message exception message
		 */
		public JobException (String message) {
			super(message);
		}

		/**
		 * Constructor used to set exception message and original exception cause
		 *
		 * @param message exception message
		 * @param cause   original exception cause
		 */
		public JobException (String message, Throwable cause) {
			super(message, cause);
		}
	}
}