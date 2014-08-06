package ro.generic.util;

public class DateUtil {

	static int savedYear, savedMonth;
	static String savedDate, savedHtmlOptions;

	static String savedHtmlOptionsWithDay;
	static int savedDay;
	static int maxDays[] = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static final String getCrtDate () {
		char c[] = new char[7];
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int year = cal.get(java.util.Calendar.YEAR);
		int month = 1 + cal.get(java.util.Calendar.MONTH);
		if (savedDate != null && savedYear == year && month == savedMonth) {
			return savedDate;
		}

		int i = 0;
		c[i++] = (char)('0' + (year / 1000));
		c[i++] = (char)('0' + ((year % 1000) / 100));
		c[i++] = (char)('0' + ((year % 100) / 10));
		c[i++] = (char)('0' + (year % 10));
		c[i++] = '-';
		c[i++] = (char)('0' + (month / 10));
		c[i++] = (char)('0' + (month % 10));
		savedYear = year;
		savedMonth = month;
		return (savedDate = new String(c, 0, i));
	}

	public static final String getCrtTime () {
		char c[] = new char[16];
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int year = cal.get(java.util.Calendar.YEAR);
		int month = 1 + cal.get(java.util.Calendar.MONTH);
		int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
		int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		int minute = cal.get(java.util.Calendar.MINUTE);

		int i = 0;
		c[i++] = (char)('0' + (year / 1000));
		c[i++] = (char)('0' + ((year % 1000) / 100));
		c[i++] = (char)('0' + ((year % 100) / 10));
		c[i++] = (char)('0' + (year % 10));
		c[i++] = '-';
		c[i++] = (char)('0' + (month / 10));
		c[i++] = (char)('0' + (month % 10));
		c[i++] = '-';
		c[i++] = (char)('0' + (day / 10));
		c[i++] = (char)('0' + (day % 10));
		c[i++] = ' ';
		c[i++] = (char)('0' + (hour / 10));
		c[i++] = (char)('0' + (hour % 10));
		c[i++] = ':';
		c[i++] = (char)('0' + (minute / 10));
		c[i++] = (char)('0' + (minute % 10));

		return new String(c, 0, i);
	}

	public static final String getMonthsHtmlOptions () {

		java.util.Calendar cal = java.util.Calendar.getInstance();
		int year = cal.get(java.util.Calendar.YEAR);
		int month = 1 + cal.get(java.util.Calendar.MONTH);

		if (savedHtmlOptions != null && year == savedYear && month == savedMonth) {
			return savedHtmlOptions;
		}


		StringBuffer sb = new StringBuffer(300);
		int startMonth = 1, endMonth = 12;
		for (int j = 2003; j <= year; j++) {
			startMonth = j == 2003 ? 10 : 1;
			endMonth = j == year ? month : 12;
			for (int i = startMonth; i <= endMonth; i++) {
				sb.append((i != month || j != year) ? "<option>" : "<option selected>");
				sb.append(j).append('-');
				if (i < 10) {
					sb.append('0');
				}
				sb.append(i).append("</option>");
			}
		}
		savedHtmlOptions = sb.toString();
		savedYear = year;
		savedMonth = month;
		return savedHtmlOptions;
	}

	public static final String getMonthsHtmlOptionsDaily () {
		return getMonthsHtmlOptionsDaily(null);
	}

	public static final String getMonthsHtmlOptionsDaily (String defaultValue) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int year = cal.get(java.util.Calendar.YEAR);
		int month = 1 + cal.get(java.util.Calendar.MONTH);
		int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

		int selectedYear = year;
		int selectedMonth = month;
		int selectedDay = day;

		if (defaultValue != null) {
			try {
				selectedYear = Integer.parseInt(defaultValue.substring(0, 4));
				selectedMonth = Integer.parseInt(defaultValue.substring(5, 7));
				selectedDay = Integer.parseInt(defaultValue.substring(8, 10));
			} catch (Exception e) {
			}
		}

		if (savedHtmlOptionsWithDay != null && year == savedYear && month == savedMonth && day == savedDay && defaultValue == null) {
			return savedHtmlOptionsWithDay;
		}

		StringBuffer sb = new StringBuffer(300);
		int startMonth = 1, endMonth = 12;

		boolean stop = false;
		for (int j = 2003; j <= year; j++) {
			startMonth = j == 2003 ? 10 : 1;
			endMonth = j == year ? month : 12;

			for (int i = startMonth; i <= endMonth; i++) {
				int noOfDaysForMonth = maxDays[i];
				if (i == 2 && ((year % 4) == 0)) {
					noOfDaysForMonth++;
				}

				for (int k = 1; k <= noOfDaysForMonth; k++) {
					stop = i == month && j == year && k == day;
					boolean selected = i == selectedMonth && j == selectedYear && k == selectedDay;
					sb.append(selected ? "<option selected>" : "<option>");
					sb.append(j).append('-');
					if (i < 10) {
						sb.append('0');
					}
					sb.append(i);
					sb.append("-");
					if (k < 10) {
						sb.append('0');
					}
					sb.append(k);
					sb.append("</option>\n");
					if (stop) {
						break;
					}
				}
				if (stop) {
					break;
				}
			}
		}
		String s = sb.toString();
		if (defaultValue == null) {
			savedHtmlOptionsWithDay = s;
			savedYear = year;
			savedMonth = month;
			savedDay = day;
		}
		return s;
	}


}