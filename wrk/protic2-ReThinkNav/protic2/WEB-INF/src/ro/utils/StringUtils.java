package ro.utils;

/**
 * <p>Title: Information System Improvement (ISI) Project
 * <p>Description: Business Activity Management </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Giurca Daniel Petru (+4)0722/689008
 * @version 1.0
 */

public class StringUtils {

        public static int string2int(String value) throws Exception{
                return Integer.parseInt(value);
        }
        public static String int2string(int value) throws Exception{
                return Integer.toString(value);
        }

        public static long string2long(String value) throws Exception{
                return Long.parseLong(value);
        }
        public static String long2string(long value) throws Exception{
                return Long.toString(value);
        }

        public static double string2double(String value) throws Exception{
                return Double.parseDouble(value);
        }
        public static String double2string(double value) throws Exception{
                return Double.toString(value);
        }

        public static boolean isEmptyString(String value){
                return ( (value==null) || (value.length() < 1) );
        }

        public static String getSQLString(String p_string) {
            if (p_string == null) {
                    return "";
            }
            String result = new String();
            for (int i = 0; i < p_string.length(); i++) {
                    char c = p_string.charAt(i);
                    if (c == '\'') {
                            result += "''";
                    } else if (c == '\\') {
                            result += "\\\\";
                    } else {
                            result += c;
                    }
            }
            return result;
        }//end getSQLString()

        public static String getSQLString(java.sql.Date date) {
                return date!=null?date.toString():"";
        }//end getSQLString()
	public static final boolean isEmpty(String source) {
		return isEmptyString(source);
	}
	public static final boolean isNotEmpty(String source) {
		return !isEmptyString(source);
	}

	public static final String getFileName(String path) {
		String result = "";
		try {
			if (isNotEmpty(path)) {
				int pos = path.lastIndexOf(java.io.File.separator);
				if (pos != -1) {
					result = path.substring(pos + 1);
				}
			}
		} catch (Exception ex) {
			result = "";
            ex.printStackTrace();
//			ro.alpi.log.Logger.getInstance().error("StringUtils::getFil(String): ERROR: ", ex);
		}
		return result;
	}

	public static final String getFileNameWithoutDate(String path) {
		String result = "";
		try {
			if (isNotEmpty(path)) {
				result = path;
				int pos = result.lastIndexOf(java.io.File.separator);
				if (pos != -1) {
					result = result.substring(pos + 1);
				}
				pos = result.lastIndexOf("-");
				if (pos != -1) {
					result = result.substring(0, pos);
				}
			}
		} catch (Exception ex) {
			result = "";
            ex.printStackTrace();		}
		return result;
	}

}