package ro.generic.util;

import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements network related utilities
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 23, 2004
 */
public class NetUtil {

	//--------------------------------------------------------//
	//                        CONSTANTS                       //
	//--------------------------------------------------------//

	public static final Pattern IP_PATTERN = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");

	//--------------------------------------------------------//
	//                      CONSTRUCTORS                      //
	//--------------------------------------------------------//

	/**
	 * Private constructor used to disable instance creation for this class
	 */
	private NetUtil () {
	}

	//--------------------------------------------------------//
	//                        STATIC METHODS                  //
	//--------------------------------------------------------//

	/**
	 * Return the ip for associated url.
	 *
	 * @param url url to extract the ip from
	 * @return ip the resolved IP or <b>null</b> for invalid url or unknown host
	 */
	public static final String getIP (String url) {
		String ip = null;
		try {
			InetAddress inetAd = InetAddress.getByName(new URL(url).getHost());
			ip = inetAd.getHostAddress();
		} catch (Exception ex) {
		}
		return ip;
	}

	/**
	 * Check a string against a valid IP format (eq. 123.22.105.128)
	 *
	 * @param ip string to test if a valid ip (in format)
	 * @return <i>true</i> if the specified string is a valid IP otherwise <i>false</i>
	 */
	public static boolean isValidIP (String ip) {
		boolean result = false;
		if ((ip != null) && (ip.length() >= 7)) {
			final Matcher matcher = IP_PATTERN.matcher(ip);
			if (matcher.matches()) {
				int number = Integer.parseInt(matcher.group(1), 10);
				result = (number > 0) && (number < 256);
				for (int i = 2; i < 5 && result; i++) {
					number = Integer.parseInt(matcher.group(i), 10);
					result = (number >= 0) && (number < 256);
				}

			}
		}
		return result;
	}

	/**
	 * Get a resource from an URL as a string
	 *
	 * @param url - url to collect
	 * @return source from URL or null if any errors occured
	 */
	public static final String getContent (URL url) {
		String source = null;
		try {
			InputStreamReader reader = new InputStreamReader(url.openStream());
			char chars[] = new char[2048];
			StringBuffer buffer = new StringBuffer(2048);
			int count;
			while ((count = reader.read(chars)) != -1) {
				buffer.append(chars, 0, count);
			}
			reader.close();
			source = buffer.toString();
		} catch (Exception ex) {
		}
		return source;
	}


}
