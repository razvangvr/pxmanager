package ro.servlets;

/**
 * Title:        doUpload.java
 * Description:  The upload servlet.
 * Copyright:    Copyright (c) 2001
 * Company:      MCRo
 * @author       Serj
 * @version      1.0  12/12/2001
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class UploadServlet extends HttpServlet {
	private static final int BUFFER_SIZE = 5 * 1024;
	private byte[] buffer = new byte[BUFFER_SIZE];

	//unknown
	private String first_line = null;

	//uncommented
	private Vector p_names  = null, p_values = null;

	//input stream
	private ServletInputStream br = null;

	//output stream
	private BufferedOutputStream bw = null;

	//the directory where the uploaded files will be stored (i.e. /upload)
//	private String uploadDir = "/temp_upload";

	private String the_file_name = null; //file name after the upload...
	private long the_size = -1; //file size after upload....
///////////////////////////////////////////////////////////////////////

	private PrintWriter m_out;
	private HttpSession session;

	//check the validity of user name & password
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//  res.sendRedirect("../Error.jsp");
		res.sendError(res.SC_BAD_REQUEST, "INVALID USE of function! ACCESS DENIED!");
        //	printErrorMessage("INVALID USE of function! ACCESS DENIED!");
	}   //  end doGet()

	public int readLine(InputStream in, byte[] b, int off, int len) throws IOException {
		if (len <= 0) {
			return 0;
		}
		int count = 0, c;
		while ((count < len) && (c = in.read()) != -1) {
			b[off++] = (byte)c;
			count++;
			if (c == '\n') {
				break;
			}
		}
		return (count > 0) ? count : -1;
	}   //  end readLine()

}   //  end class UploadServlet

