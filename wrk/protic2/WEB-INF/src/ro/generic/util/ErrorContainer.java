package ro.generic.util;

import java.util.HashMap;

/**
 * ErrorContainer class is used to collect all the errors that will be reportd in the application in a map approach
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 27, 2004
 */
public class ErrorContainer extends HashMap {

	//---------------------------------------------------------//
	//                        CONSTANTS                        //
	//---------------------------------------------------------//

	public static final String ERROR_CONTAINER_KEY = "ERROR_CONTAINER_KEY"; // key used to store the errors in various contexts
	public static final int DEFAULT_CAPACITY = 3; // default map capacity

	//--------------------------------------------------------//
	//                          FIELDS                        //
	//--------------------------------------------------------//

	private boolean hasNewErrors; // marker used to check new errors

	//---------------------------------------------------------//
	//                      CONSTRUCTORS                       //
	//---------------------------------------------------------//

	/**
	 * Hidden container used to initialize the map capacity
	 *
	 * @param size initial capacity
	 */
	private ErrorContainer (int size) {
		super(size);
	}

	//--------------------------------------------------------//
	//                OVERWRITES 'HashMap'                    //
	//--------------------------------------------------------//

	public Object put (Object key, Object value) {
		// update the new errors flag
		hasNewErrors = true;
		return super.put(key, value);
	}

	public void clear () {
		// clear new errors flag
		hasNewErrors = true;
		super.clear();
	}
	//--------------------------------------------------------//
	//                         METHODS                        //
	//--------------------------------------------------------//

	/**
	 * Check if the given error is registered
	 *
	 * @param name
	 * @return
	 */
	public boolean hasError (String name) {
		return get(name) != null;
	}

	/**
	 * Return an error by name.If the error is not found , an null is returned.
	 *
	 * @param name error name/key
	 * @return error String value
	 */
	public String getError (String name) {
		Object error = get(name);
		return (error != null) ? String.valueOf(error) : null;
	}

	/**
	 * Return an error by name.If the error is not found , an empty string is returned.
	 *
	 * @param name error name/key
	 * @return error String value
	 */
	public String getErrorOrEmpty (String name) {
		Object error = get(name);
		return (error != null) ? String.valueOf(error) : "";
	}

	/**
	 * Register an error in the container that will automatically register the toString() version of object
	 *
	 * @param name  error name/key
	 * @param value error value/description
	 */
	public void setError (String name, Object value) {
		put(name, value.toString());
	}

	//---------------------------------------------------------//
	//                         STATIC METHODS                  //
	//---------------------------------------------------------//

	/**
	 * Create a new instance of ErrorContainer with default capacity
	 *
	 * @return new created error container
	 */
	public static final ErrorContainer createErrorContainer () {
		return createErrorContainer(DEFAULT_CAPACITY);
	}

	/**
	 * Create a new instance of ErrorContainer with specified capacity
	 *
	 * @param size initial capacity
	 * @return new created error container
	 */
	public static final ErrorContainer createErrorContainer (int size) {
		return new ErrorContainer(size);
	}

	/**
	 * Create a new instance of ErrorContainer and automatically register the error
	 *
	 * @param errors     error container to register the error , if <b>null</b> one is created
	 * @param errorKey   error name/key
	 * @param errorValue error value
	 * @return new created error container
	 */
	public static final ErrorContainer setError (ErrorContainer errors, String errorKey, Object errorValue) {
		errors = errors == null ? new ErrorContainer(1) : errors;
		errors.setError(errorKey, errorValue);
		return errors;
	}

	/**
	 * Clean up an error container and return if the container exist
	 *
	 * @param errors error container to be cleanup
	 */
	public static final void clear (ErrorContainer errors) {
		if (errors != null) {
			errors.clear();
		}
	}

	/**
	 * Check if there are any errors registered in the given container
	 *
	 * @param errors error container to be checked
	 * @return return <i>true</i> if errors are registered otherwise <i>false</i>
	 */
	public static final boolean hasErrors (ErrorContainer errors) {
		return (errors != null) ? errors.isEmpty() : false;
	}

	/**
	 * Check if there are any new errors registered in the specified container
	 *
	 * @param errors error container to be checked
	 * @return return <i>true</i> if new errors are registered otherwise <i>false</i>
	 */
	public static final boolean hasNewErrors (ErrorContainer errors) {
		return errors != null ? errors.hasNewErrors : false;
	}

	/**
	 * Reset new errors flag for the specified error container
	 *
	 * @param errors error container to be checked
	 */
	public static final void resetNewErrors (ErrorContainer errors) {
		if (errors != null) {
			errors.hasNewErrors = false;
		}
	}
}
