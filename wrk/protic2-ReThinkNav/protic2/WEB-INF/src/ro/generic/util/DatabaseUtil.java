package ro.generic.util;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class implements database related utilities
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 23, 2004
 */
public class DatabaseUtil {

	//--------------------------------------------------------//
	//                      CONSTRUCTORS                      //
	//--------------------------------------------------------//

	/**
	 * Private constructor used to disable instance creation for this class
	 */
	private DatabaseUtil () {
	}

	//--------------------------------------------------------//
	//                        STATIC METHODS                  //
	//--------------------------------------------------------//

	/**
	 * Dump a result set as a string for debug purposes
	 *
	 * @param result        result set to be dumped
	 * @param maxColumnSize maximum number of characters in a column
	 * @throws SQLException
	 */
	public static String dumpResultSet (ResultSet result, int maxColumnSize) throws SQLException {
		ResultSetMetaData metadata = result.getMetaData();
		// extract header
		int count = metadata.getColumnCount();
		int[] maxCols = new int[count];
		int[] alignCols = new int[count];
		String[] header = new String[count];
		int align;
		for (int i = 0; i < count; i++) {
			header[i] = metadata.getColumnName(i + 1);
			maxCols[i] = header[i].length();
			align = metadata.getColumnType(i + 1);
			alignCols[i] = (align == Types.VARCHAR || align == Types.CHAR || align == Types.LONGVARCHAR) ? StringUtil.ALIGN_LEFT : StringUtil.ALIGN_RIGHT;
		}
		// populate list
		ArrayList list = new ArrayList();
		String[] row;
		String value;
		int len;
		while (result.next()) {
			row = new String[count];
			for (int i = 0; i < count; i++) {
				row[i] = value = String.valueOf(result.getObject(i + 1));
				len = value.length();
				if (len > maxColumnSize) {
					len = maxColumnSize;
				}
				if (len > maxCols[i]) {
					maxCols[i] = len;
				}
			}
			list.add(row);
		}
		len = String.valueOf(list.size()).length();
		// generate table
		count = maxCols.length;
		int lineChars = 3 + len + 2;
		while (count-- != 0) {
			lineChars += 3 + maxCols[count];
		}
		StringBuffer buf = new StringBuffer((count + 4) * lineChars);
		buf.append("| ").append(StringUtil.pad("#", ' ', len, StringUtil.ALIGN_CENTER)).append(" |");
		String sepFull = StringUtil.fill('-', lineChars);
		String sep = "+" + sepFull.substring(0, len + 2) + "+";
		count = maxCols.length;
		for (int i = 0; i < count; i++) {
			buf.append(" ").append(StringUtil.pad(header[i], ' ', maxCols[i], StringUtil.ALIGN_CENTER)).append(" |");
			sep += sepFull.substring(0, maxCols[i] + 2) + "+";
		}
		sep += "\n";
		buf.append('\n');
		buf.insert(0, sep);
		buf.append(sep);
		int size = list.size();
		if (size == 0) {
			buf.append("| ").append(StringUtil.pad("<EMPTY>", ' ', lineChars - 5, StringUtil.ALIGN_LEFT)).append(" |").append('\n');
		} else {
			for (int l = 0; l < size; l++) {
				buf.append("| ").append(StringUtil.pad(Integer.toString(l), ' ', len, StringUtil.ALIGN_RIGHT)).append(" |");
				header = (String[])list.get(l);
				for (int i = 0; i < count; i++) {
					buf.append(" ").append(StringUtil.pad(header[i], ' ', maxCols[i], alignCols[i])).append(" |");
				}
				buf.append("\n");
			}
		}
		buf.append(sep);
		return buf.toString();
	}

	/**
	 * Silently close the specified connection , statement and result set
	 *
	 * @param con       connection to close
	 * @param statement statement to close
	 * @param result    result set to close
	 */
	public static void close (Connection con, Statement statement, ResultSet result) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
			}
		}
	}
}