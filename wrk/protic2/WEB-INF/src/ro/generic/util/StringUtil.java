package ro.generic.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * This class implements string related utilities
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, 10.06.2004
 */
public class StringUtil {

	//--------------------------------------------------------//
	//                        CONSTANTS                       //
	//--------------------------------------------------------//

	// string alignment
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_RIGHT = 2;

	// constant strings
	public static final String EMPTY_STRING = "";
	private static final String SPACES_STRING = "                                                                                                                                             ";
	private static final int SPACES_STRING_LENGTH = SPACES_STRING.length();

	// hex chars (upper, lower)
	private static final char[] HEX_CHARS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
	                                               'E', 'F'
	};
	private static final char[] HEX_CHARS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
	                                               'e', 'f'
	};

	/**
	 * Identity comparator
	 */
	public static final Comparator STRING_COMPARATOR = new Comparator() {

		//--------------------------------------------------------//
		//                   IMPLEMENTS 'Comparator'              //
		//--------------------------------------------------------//

		public int compare (Object o1, Object o2) {
			return String.valueOf(o1).compareTo((String) o2);
		}

	};

	//--------------------------------------------------------//
	//                      CONSTRUCTORS                      //
	//--------------------------------------------------------//

	/**
	 * Private constructor used to disable instance creation for this class
	 */
	private StringUtil () {
	}

	//--------------------------------------------------------//
	//                        STATIC METHODS                  //
	//--------------------------------------------------------//

	/**
	 * Create a non-shared string (as StringBuffer.toString() is implemented) to avoid memory
	 * leaking because of char/string shareing
	 *
	 * @param buffer string buffer to be copied as a string
	 * @return new created string
	 */
	public static final String toString (StringBuffer buffer) {
		int len = buffer.length();
		char[] chars = new char[len];
		buffer.getChars(0, len, chars, 0);
		return new String(chars);
	}


	/**
	 * Generate a random string based on current millisec
	 *
	 * @return generated random string
	 */
	public static final String getRandom () {
		return Long.toHexString(System.currentTimeMillis());
	}

	/**
	 * Return the first token in a string that use the specified separator
	 *
	 * @param str string to tokenize
	 * @param sep separator used
	 * @return first token in the sequence using the separator
	 */
	public static final String getFirstToken (String str, char sep) {
		String first = null;
		if (str != null) {
			int index = str.indexOf(sep);
			first = index != -1 ? str.substring(0, index) : str;
		}
		return first;
	}

	/**
	 * Add a new token to a list using the specified separator and return the new token list.
	 * If the list is <b>null</b> or <b>"" (an empty string)</b> a new list will be created containing just the new token
	 * If the token is already in list the original list will be returned
	 *
	 * @param str        string/token list
	 * @param tok        token to be added
	 * @param sep        separator used
	 * @param ignoreCase check case sensitivity for comparitions
	 * @return updated token list
	 */
	public static final String addToken (String str, String tok, char sep, boolean ignoreCase) {
		if (tok != null) {
			if (str == null || str.length() == 0) { // new token
				str = tok;
			} else if (getTokenIndex(str, tok, sep, ignoreCase) == -1) { // not found
				str = str.concat(String.valueOf(sep)).concat(tok);
			}
		}
		return str;
	}

	/**
	 * Remove a token from a list using the specified separator and return the new token list.
	 * If the token is not found in the token list , the original list will be returned
	 *
	 * @param str        string/token list
	 * @param tok        token to be removed
	 * @param sep        separator used
	 * @param ignoreCase check case sensitivity for comparitions
	 * @return updated token list
	 */
	public static final String removeToken (String str, String tok, char sep, boolean ignoreCase) {
		if (tok != null && str != null) {
			int index = getTokenIndex(str, tok, sep, ignoreCase);
			if (index != -1) { // token found
				int len = str.length();
				int last ;
				last = ((last = index + tok.length()) == len) ? len : (last + 1);
				index = (last == len && index != 0) ? index - 1 : index;
				str = str.substring(0, index).concat(str.substring(last));
			}
		}
		return str;
	}

	/**
	 * Return all the tokens in a string that use the specified separator
	 *
	 * @param str string to tokenize
	 * @param sep separator used
	 * @return tokens list or null if the string is null
	 */
	public static final String[] getTokens (String str, char sep) {
		String tokens[] = null;
		if (str != null) {
			int index, lastIndex = 0;
			ArrayList list = new ArrayList();
			while ((index = str.indexOf(sep, lastIndex)) != -1) {
				list.add(str.substring(lastIndex, index));
				lastIndex = index + 1;
			}
			list.add(str.substring(lastIndex));
			list.toArray(tokens = new String[list.size()]);
		}
		return tokens;
	}

	/**
	 * Return the index of a token in a string that use the specified separator
	 *
	 * @param str        string to tokenize
	 * @param tok        token to looking for
	 * @param sep        separator used
	 * @param ignoreCase check case sensitivity for comparitions
	 * @return index of the found token or -1 if the token is not found
	 */
	public static final int getTokenIndex (String str, String tok, char sep, boolean ignoreCase) {
		int index = -1;
		if (str != null & tok != null) {
			int len = tok.length();
			int startIndex, lastIndex = 0;
			while ((startIndex = str.indexOf(sep, lastIndex)) != -1) {
				if ((lastIndex + len == startIndex) && str.regionMatches(ignoreCase, lastIndex, tok, 0, len)) {
					index = lastIndex;
					break;
				}
				lastIndex = startIndex + 1;
			}
			if ((index == -1) && (lastIndex + len == str.length()) && str.regionMatches(ignoreCase, lastIndex, tok, 0, len)) {
				index = lastIndex;
			}
		}
		return index;
	}

	/**
	 * Return a joined string representation of the array based on the specified separator
	 *
	 * @param array string to tokenize
	 * @param sep   separator used to generate the addBean
	 * @return joined string
	 */
	public static final String joinTokens (String array[], char sep) {
		String result = null;
		if (array != null) {
			int len = array.length;
			StringBuffer sb = new StringBuffer(len << 3); // *8
			String tmp;
			for (int i = 0; i < len; i++) {
				tmp = array[i] != null ? array[i] : EMPTY_STRING;
				sb.append(tmp).append(sep);
			}
			sb.setLength(sb.length() - 1); // delete last appended separator
			result = sb.toString();
		}
		return result;
	}

	/**
	 * Return the index of a string in a string array (case insensitive)
	 *
	 * @param list       string list
	 * @param value      value to search for
	 * @param ignoreCase case sensitivity flag for search
	 * @return index of the string, if value is <b>null</b> -1 is returned
	 */
	public static final int indexOf (String[] list, String value, boolean ignoreCase) {
		int index = -1;
		if (list != null && value != null) {
			index = ArrayUtil.indexOf(list, 0, list.length - 1, value, ignoreCase ? String.CASE_INSENSITIVE_ORDER : STRING_COMPARATOR);
		}
		return index;
	}

	/**
	 * Return the escaped string if there are any HTML characters in the original string
	 *
	 * @param data string to be escaped
	 * @return HTML escaped version of the string (if any character encountered)
	 */
	public static final String escapeHtml (String data) {
		char chr;
		int len = data == null ? 0 : data.length();
		StringBuffer buffer = null;
		String escape = null;
		for (int i = 0; i < len; i++) {
			chr = data.charAt(i);
			if (chr == '<') {
				escape = "&lt;";
			} else if (chr == '>') {
				escape = "&gt;";
			} else if (chr == '&') {
				escape = "&amp;";
			} else {
				if (buffer != null) {
					buffer.append(chr);
				}
				continue;
			}
			if (buffer == null) {
				buffer = new StringBuffer(len + 13);
				buffer.append(data);
				buffer.setLength(i);
			}
			buffer.append(escape);
		}
		if (buffer != null) {
			data = new String(buffer);
		}
		return data;
	}

	/**
	 * Add a number of specified character in front and/or at end of the string based on formating and number of positions.
	 *
	 * @param str    string to pad; if longer than specified length it will be split according to the alignment
	 * @param chr    character used for padding
	 * @param length number of available positions to be used
	 * @param align  alignment
	 * @return generated string
	 */
	public static final String pad (String str, char chr, int length, int align) {
		String result;
		int size = str.length();
		int diff = length - size;
		if (diff < 0) {
			diff = -diff;
		}
		int index = (align == ALIGN_CENTER) ? (diff >> 1) : ((align == ALIGN_RIGHT) ? diff : 0);
		if (size > length) {
			result = str.substring(index, index + length);
		} else {
			char chars[] = fill(chr, length).toCharArray();
			str.getChars(0, size, chars, index);
			result = new String(chars);
		}
		return result;
	}

	/**
	 * Get a string that consists of the specified number of spaces.
	 *
	 * @param count number of spaces; if invalid <i>(<=0)</i> the an empty string will be returned
	 * @return string with requested number of spaces
	 */
	public static final String spaces (int count) {
		String result = EMPTY_STRING;
		if (count > 0) {
			if (count > SPACES_STRING_LENGTH) {
				char[] chars = new char[count];
				while ((count -= SPACES_STRING_LENGTH) > 0) {
					SPACES_STRING.getChars(0, SPACES_STRING_LENGTH, chars, count);
				}
				if (count < 0) {
					SPACES_STRING.getChars(0, SPACES_STRING_LENGTH + count, chars, 0);
				}
				result = new String(chars);
			} else {
				result = SPACES_STRING.substring(0, count);
			}
		}
		return result;
	}

	/**
	 * Get a string created repeting a specified character by a specified number.
	 *
	 * @param chr   character to repeat
	 * @param count number of specified characters
	 * @return result string
	 */
	public static final String fill (char chr, int count) {
		String result = EMPTY_STRING;
		if (chr == ' ') {
			result = spaces(count);
		} else if (count > 0) {
			char chars[] = new char[count];
			while (count-- != 0) {
				chars[count] = chr;
			}
			result = new String(chars);
		}
		return result;
	}

	/**
	 * Turns array of bytes into string representing each byte as unsigned hex number.
	 *
	 * @param array     array of bytes to convert to hex-string
	 * @param upperCase <i>true</i> for uppercase hex characters <i>false</i> for lowercase hex characters
	 * @return	generated hex string representation
	 */
	public static String toHex (byte array[], boolean upperCase) {
		int value;
		int length = array.length;
		int index = length << 1;
		char[] hexChars = upperCase ? HEX_CHARS_UPPER : HEX_CHARS_LOWER;
		char[] chars = new char[index];
		while (length-- != 0) {
			value = array[length];
			chars[--index] = hexChars[value & 0x0F];
			chars[--index] = hexChars[(value & 0xF0) >> 4];
		}
		return new String(chars);
	}

	/**
	 * Generate a password with the specified length.
	 *
	 * @param length password length
	 * @return password - generated password
	 */
	public static String generatePassword (int length) {
		Random random = new Random();
		char[] pass = new char[length];
		while (length-- != 0) {
			pass[length] = HEX_CHARS_LOWER[random.nextInt(HEX_CHARS_LOWER.length)];
		}
		return new String(pass);
	}


}
