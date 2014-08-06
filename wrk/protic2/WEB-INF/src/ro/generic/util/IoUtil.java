package ro.generic.util;

import java.io.*;

/**
 * This class implements io/streams related utilities
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, 10.06.2004
 */
public class IoUtil {

	//--------------------------------------------------------//
	//                      CONSTRUCTORS                      //
	//--------------------------------------------------------//

	/**
	 * Private constructor used to disable instance creation for this class
	 */
	private IoUtil () {
	}

	//--------------------------------------------------------//
	//                        STATIC METHODS                  //
	//--------------------------------------------------------//

	/**
	 * Copy an input file in an output file.
	 *
	 * @param source source file
	 * @param dest   destination file
	 * @return copy total number of bytes copied or <b>-1</b> if errors reported
	 */
	public static int copyFiles (String source, String dest) {
		int count = -1;
		InputStream in = null;
		OutputStream out = null;
		try {
			count = copy(in = new BufferedInputStream(new FileInputStream(source)), out = new BufferedOutputStream(new FileOutputStream(dest)));
		} catch (Exception ex) {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
			ex.printStackTrace();
		}
		return count;
	}

	/**
	 * Copy an input stream in an output stream..
	 *
	 * @param in  input stream to copy from
	 * @param out output stream to copy to
	 * @return copy total number of bytes copied or <b>-1</b> if errors reported
	 */
	public static int copy (InputStream in, OutputStream out) {
		return copy(in, out, new byte[1 << 14]); // buffer is 16 kb
	}

	/**
	 * Copy an input stream in an output stream..
	 *
	 * @param in     input stream to copy from
	 * @param out    output stream to copy to
	 * @param buffer buffer used for copy (to be reused from application)
	 * @return copy total number of bytes copied or <b>-1</b> if errors reported
	 */
	public static int copy (InputStream in, OutputStream out, byte[] buffer) {
		int count = 0;
		try {
			int read = 0;
			while (read != -1) {
				read = in.read(buffer);
				if (read > 0) {
					count += read;
					out.write(buffer, 0, read);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			count = -1;
		}
		return count;
	}

	/**
	 * Remnove all files in a directory
	 *
	 * @param directory  directory to be cleared
	 * @param removeDirs remove also subdirectories
	 */
	public static void clearDirectory (String directory, boolean removeDirs) {
		try {
			File file = new File(directory);
			if (file.exists()) {
				String files[] = file.list();
				File tmp;
				if (files != null) {
					for (int i = 0; i < files.length; i++) {
						tmp = new File(directory, files[i]);
						if (tmp.isDirectory()) {
							clearDirectory(tmp.getAbsolutePath(), removeDirs);
							if (!removeDirs) {
								continue;
							}
						}
						tmp.delete();
					}
				}
			}
		} catch (Exception exception) {
		}
	}

}
