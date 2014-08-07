package ro.generic.util;

/**
 * This class implements number related utilities
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 23, 2004
 */
public class NumberUtil {

	//--------------------------------------------------------//
	//                      CONSTRUCTORS                      //
	//--------------------------------------------------------//

	/**
	 * Private constructor used to disable instance creation for this class
	 */
	private NumberUtil () {
	}

	//--------------------------------------------------------//
	//                        STATIC METHODS                  //
	//--------------------------------------------------------//

	/**
	 * Check if the specified bit is set in the associated bitwise map
	 *
	 * @param map bitwise int map
	 * @param bit bit index
	 * @return <i>true</i> if the bit is <b>1</b>, <i>false</i> if the bit is <b>0</b>
	 */
	public static final boolean isBitSet (int map, int bit) {
		return (map & (1 << bit)) != 0;
	}

	/**
	 * Check if the specified bit is set in the associated bitwise map
	 *
	 * @param map bitwise long map
	 * @param bit bit index
	 * @return <i>true</i> if the bit is <b>1</b>, <i>false</i> if the bit is <b>0</b>
	 */
	public static final boolean isBitSet (long map, int bit) {
		return (map & (1L << bit)) != 0;
	}

	/**
	 * Parse a string as an int with default value if there are any errors
	 *
	 * @param value        string to parse
	 * @param defaultValue default value to return if there are any errors
	 * @return parsed representation of the string or default value
	 */
	public final static int parseInt (String value, int defaultValue) {
		try {
			return value != null ? Integer.parseInt(value) : defaultValue;
		} catch (NumberFormatException e) {
			return defaultValue;
		}catch (NullPointerException e) {
			return defaultValue;
		}
	}

	/**
	 * Parse a string as a long with default value if there are any errors
	 *
	 * @param value        string to parse
	 * @param defaultValue default value to return if there are any errors
	 * @return parsed representation of the string or default value
	 */
	public final static long parseLong (String value, long defaultValue) {
		try {
			return value != null ? Long.parseLong(value) : defaultValue;
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * Parse a string as a float with default value if there are any errors
	 *
	 * @param value        string to parse
	 * @param defaultValue default value to return if there are any errors
	 * @return parsed representation of the string or default value
	 */
	public final static float parseFloat (String value, float defaultValue) {
		try {
			return value != null ? Float.parseFloat(value) : defaultValue;
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * Parse a string as a double with default value if there are any errors
	 *
	 * @param value        string to parse
	 * @param defaultValue default value to return if there are any errors
	 * @return parsed representation of the string or default value
	 */
	public final static double parseDouble (String value, float defaultValue) {
		try {
			return value != null ? Double.parseDouble(value) : defaultValue;
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

}
