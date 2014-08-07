package ro.generic.util;

import java.util.Date;
import java.util.TimerTask;

/**
 * This abstract class is the basement to implement job/task related objects
 *
 * @author Ion Badita (yonic)
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 3, 2004
 */
public abstract class Job implements Runnable {

	//---------------------------------------------------------//
	//                        CONSTANTS                        //
	//---------------------------------------------------------//

	public static final long SECONDLY = 1000;
	public static final long MINUTELY = SECONDLY * 60;
	public static final long HOURLY = MINUTELY * 60;
	public static final long DAILY = HOURLY * 24;
	public static final long WEEKLY = DAILY * 7;
	public static final long DEFAULT_PERFORM = DAILY;

	public static final int FLAG_THREAD = 1;
	public static final int FLAG_CANCEL = 2;

	public final static int RUN_FOREVER = Integer.MIN_VALUE;
	public final static int RUN_ONCE = 1;

	//---------------------------------------------------------//
	//                         STATIC FIELDS                   //
	//---------------------------------------------------------//

	private static int threadCount;

	//---------------------------------------------------------//
	//                          FIELDS                         //
	//---------------------------------------------------------//

	private Throwable lastException;
	private boolean useThread;
	private boolean firstTime;
	private boolean exceptionCancel;
	private JobThread thread;
	private JobTask task;
	private int runCount;
	private long startDelay;
	private long delay;
	private String name;
	private JobScheduler scheduler;

	//---------------------------------------------------------//
	//                      CONSTRUCTORS                       //
	//---------------------------------------------------------//

	/**
	 * Default constructor
	 */
	protected Job () {
		runCount = RUN_FOREVER;
		firstTime = true;
		task = new JobTask();
	}

	//---------------------------------------------------------//
	//                         OVERWRITES 'Object'             //
	//---------------------------------------------------------//

	public String toString () {
		return "Job [\"" + getName() + "\", start: " + new Date(getStartDelay() + System.currentTimeMillis()) + ", delay: " + getDelay() + ", count: " + (runCount == RUN_FOREVER ? "forever" : String.valueOf(runCount)) + ", flags: {" + (useThread ? " thread" : "") + (exceptionCancel ? " exception" : "") + " }]";
	}

	//---------------------------------------------------------//
	//                         METHODS                         //
	//---------------------------------------------------------//

	/**
	 * Initialize a job with all necessary data
	 *
	 * @param name    job name
	 * @param date    job start date
	 * @param perform job performing model
	 * @param count   job number of execution
	 * @param flags   job type
	 */
	public void initJob (String name, Date date, long perform, int count, int flags) {
		this.name = name;
		useThread = (flags & FLAG_THREAD) == FLAG_THREAD;
		exceptionCancel = (flags & FLAG_CANCEL) == FLAG_CANCEL;
		runCount = count;
		delay = perform;
		long time = date.getTime() - System.currentTimeMillis();
		startDelay = time < 0 ? 0 : time;
	}

	/**
	 * Notification method called once a job is started.Should be overwritten for custom handlings.
	 */
	public void jobStart () {

	}

	/**
	 * Notification method called once a job is stopped.Should be overwritten for custom handlings.
	 */
	public void jobDestroy () {

	}

	/**
	 * Return start delay
	 *
	 * @return start delay
	 */
	public long getStartDelay () {
		return startDelay;
	}

	/**
	 * Get job delay between executions
	 *
	 * @return job delay
	 */
	public long getDelay () {
		return delay;
	}

	/**
	 * Return last exception during the job execution
	 *
	 * @return last exception
	 */
	public Throwable getLastException () {
		return lastException;
	}

	/**
	 * Return job name
	 *
	 * @return name
	 */
	public String getName () {
		return name;
	}


	/**
	 * Return job associated timer task
	 *
	 * @return internal timer task
	 */
	TimerTask getTask () {
		return task;
	}

	/**
	 * Set/clear job scheduler associated with this job
	 */
	void setScheduler (JobScheduler sched) {
		scheduler = sched;
	}

	/**
	 * Cancel the job
	 */
	void cancel () {
		task.cancel();
	}

	/**
	 * Launch a job in execution
	 */
	private void jobExecute () {
		try {
			if (firstTime) {
				firstTime = false;
				jobStart();
			}
			run();
		} catch (Throwable e) {
			lastException = e;
		} finally {
			if (((runCount != RUN_FOREVER) && (--runCount <= 0)) || (exceptionCancel && (lastException != null))) {
				scheduler.removeJob(this);
			}
		}
	}

	/**
	 * Reset a job
	 */
	private void jobReset () {
		if (useThread) {
			if (thread != null) {
				thread.cancel();
				thread.interrupt();
			}
		}
		jobDestroy();
	}


	//---------------------------------------------------------//
	//                      INNER CLASSES                      //
	//---------------------------------------------------------//

	/**
	 * Internal class used to wrap a TimerTask as a JobTask
	 */
	private class JobTask extends TimerTask {

		//---------------------------------------------------------//
		//                     OVERWRITES 'TimerTask'              //
		//---------------------------------------------------------//

		/**
		 * Run the task
		 */
		public void run () {
			if (useThread) {
				if (thread == null) {
					thread = new JobThread(Job.this);
					thread.start();
				} else {
					thread.wake();
				}
			} else {
				jobExecute();
			}
		}

		/**
		 * Cancel the task
		 *
		 * @return cancelation result
		 */
		public boolean cancel () {
			try {
				return super.cancel();
			} finally {
				jobReset();
			}
		}
	};

	/**
	 * Internal class used to wrap a Thread as a JobThread
	 */
	private class JobThread extends Thread {

		//---------------------------------------------------------//
		//                          FIELDS                         //
		//---------------------------------------------------------//

		public boolean run = true;

		//---------------------------------------------------------//
		//                      CONSTRUCTORS                       //
		//---------------------------------------------------------//

		/**
		 * Constuctor used to set the runnable target for the thread
		 *
		 * @param target
		 */
		public JobThread (Runnable target) {
			super(target, "JobThread - " + (threadCount++));
			setDaemon(true); // set as daemon
		}

		//---------------------------------------------------------//
		//                         OVERWRITES 'Thread'              //
		//---------------------------------------------------------//

		public void run () {
			while (run) {
				jobExecute();
				idle();
			}
		}

		//---------------------------------------------------------//
		//                         METHODS                         //
		//---------------------------------------------------------//

		/**
		 * Wake up the thread (notify)
		 */
		synchronized void wake () {
			notify();
		}

		/**
		 * Cancel the thread
		 */
		void cancel () {
			run = false;
		}

		/**
		 * Put the thread in sleep/idle mode
		 */
		private synchronized void idle () {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

	}

}
