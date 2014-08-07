<%@ page import="java.util.Vector,
                 java.io.*,
                 java.util.Properties,
                 java.util.Enumeration,
                 ro.servlets.init.InitServlet,
                 ro.auto.beans.UsersBean"%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
    String initialUpload = InitServlet.uploadsdir;
    /*InitServlet.uploadsdir= "/Program Files (x86)/Apache Software Foundation/Tomcat 5.0/webapps/protic/edit/media";
    String relative_path_file = InitServlet.uploadsdir+ "/";*/

    String relative_path_file = InitServlet.resources+ "/";
    if (request.getParameter("Del")!=null) {
        String filename = request.getParameter("filename");
//        id =  (String) session.getAttribute("id");
        System.out.println("id = = = "+filename);
//        File f = new File(relative_path_file + id + "/" + filename);
        File f = new File(relative_path_file +  filename);
        f.delete();
        System.out.println("path "+ f.getAbsolutePath());
    } else if (request.getParameter("add")!=null) {
    }
  //  id =  (String) session.getAttribute("id");
    uploadFile(request,response, relative_path_file);


%>
<BODY BACKGROUND="../img/bac.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../menupagina.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br><BR>
    <h2 align=center>Resurse</h2>
    <BR><BR>
        <FORM  action="upload1.jsp" method="POST" name="UploadForm" enctype="multipart/form-data" onsubmit="return validateForm();">
            <table width="400" border="0" cellpadding="0">
               <tr>
                <td colspan="2" align="left" >
                                   Alege fisier:
                                </td>
                                <td align="right" >
                                <input TYPE="file" NAME="fileName">
                                        <input TYPE="hidden" NAME="inportFile" value="true">
                                </td>
                        </tr>
                        <tr>
                                <td>&nbsp;</td><td>&nbsp;</td>
                                <td align="right" >
                                        <INPUT TYPE="submit" name="add" VALUE="Adauga" CLASS="button">
<%--                                        <INPUT TYPE="button" VALUE="Cancel" CLASS="button" onclick="window.close();">--%>
                                </td>
                        </tr>
                </table>
        </FORM>
                                </td>
                        </tr>
                </table>

                <table>
                        <tr><td width="180" nowrap>&nbsp;</td> </tr>

<%
    File f = new File(relative_path_file);
    if(f.exists()) {
    String[] files = f.list();
        for(int i=0; i<files.length; i++) {
%>
                <%if(i%4 == 0) {%>
                    </tr><tr><td>&nbsp;</td>
                <%}%>
            <tr>
            <td width="180" nowrap></td>
            <td width="180" nowrap></td>
            <td width="180" nowrap>
                <A HREF="<%="../edit"+InitServlet.resources.substring(InitServlet.resources.lastIndexOf("/")) + "/"+files[i]%>"/><%=files[i]%>
                </A>
            </td>
            <td>
                <form name="form1<%=i%>" method="post" action="upload1.jsp">
                    <input type="submit" name="Del" value="Sterge">
                    <input type="hidden" name="filename" value="<%=files[i]%>">
                </form>
            </td>
            </tr>
<%      }
    }

        InitServlet.uploadsdir = initialUpload;
%>
                </table>

</body>
</HTML>
<%!
    String absolute_path_file = null;
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
    public String uploadFile(HttpServletRequest req, HttpServletResponse resp, String relative_path_file) throws IOException {

        resp.setContentType("text/html");
        m_out = resp.getWriter();

        p_names = new Vector();
        p_values = new Vector();

        try {
            //content length & content type
            String cType = req.getContentType();
            if (cType!=null && !cType.startsWith("multipart/form-data")) {//if (cType.startsWith("application/x-www-form-urlencoded"))
                return null;
            } else {
//			    out.println("<P>Multipart content OK.</P>");
            }

            //get a input stream from client
            br = req.getInputStream();
            if (br == null) {
                return null;
            }

            // get the first line (something like "-----------------------------7d181366ef03b4")
            int count = br.readLine( buffer, 0, buffer.length);
            if (count == -1) {
                return null;
            }
            first_line = new String(buffer, 0, count);
            first_line = first_line.trim(); //delete the '\n' from end of line  ;-)

            String line = null;
            count = br.readLine(buffer, 0, buffer.length);
            line = new String(buffer, 0, count);
            while (count != -1) {
                if (line.startsWith(first_line)) {
                    if (line.equals(first_line + "--")) { //it's end of stream ?
                      break;
                    }
                } else if (line.startsWith("Content-Disposition")) {
                    if (line.indexOf("name=") != -1) {
                        if (line.indexOf("; filename=") != -1) {//is the filename
//							m_out.print("<table><tr><td>Getting file...</td></tr></table>");
                            line = getFileFromStream(line, m_out, req, relative_path_file);
                            /*out.println("<BR>line after reading file: " + line); */
//							m_out.println("<BR>.<b>Done</b> with file.");
                            if (line != null) {
                                continue;
                            }
                        } else { //is not the filename, it's a parameter...
                            /*out.println("taking parameter ... ");*/
                            getParamFromStream(line);
                            /*out.println("done<BR>");*/
                        }
                    } else {
                        return null;
                    }
                } else { //if (line.startsWith("Content-Type")) // just ignore...
                    /* do nothing */
                }
                count = br.readLine(buffer, 0, buffer.length);
                if (count == -1) {
                    break;
                }
                line = new String(buffer, 0, count);
            }

            br.close();



        } catch (IOException exc){
            System.err.println("UploadServlet:: doPost(): I/O ERROR: " + exc.toString());
            exc.printStackTrace(System.err);
            return null;
        } catch (Exception exc) {
            System.err.println("UploadServlet:: doPost(): ERROR: " + exc.toString());
            exc.printStackTrace(System.err);
            return null;
        }

//		session.setAttribute("the_file", the_file_name);
//		if (m_out != null) {
//			try {
//				m_out.close();
//			} catch (Exception ex) {}
//			m_out = null;
//		}
        return the_file_name;
    }//end doPost()


    private String getFileFromStream(String s, PrintWriter out, HttpServletRequest req, String relative_path_file) throws IOException {
        String aux = s;
        int p1 = aux.indexOf("name=");
        int p2 = aux.indexOf("; filename=");
        String pname = aux.substring(p1 + 6, p2 - 1);		// param name
        String pvalue = aux.substring(p2 + 12, aux.length() - 1); // filepath
        p1 = pvalue.lastIndexOf("/");
        if (p1 == -1) {
            p1 = pvalue.lastIndexOf("\\");
//			if (p1 == -1) {
//				p1 = 0;
//			}
        }
        p2 = pvalue.lastIndexOf("\"");
        pvalue = pvalue.substring(p1 + 1, p2); // filename
        System.err.println("FILE NAME: " + pvalue);
        if(pvalue==null || pvalue.length()==0)
            return null;

        int count = 0;
        p_names.addElement(pname);
        p_values.addElement(pvalue);


//        File f = new File("/Program Files/Apache Tomcat 4.0/webapps/terenuri/UPLOADS");
        File f = new File(relative_path_file);// + (String) req.getSession().getAttribute("id"));

//        File f = new File("/home/alpi/jakarta-tomcat/webapps/terenuri/UPLOADS");
        if (!f.exists()) {
            //create temporary upload dir...
            f.mkdirs();
        }
        the_file_name = pvalue;



        if (pvalue.length() > 0) { //if filename is valid (not empty)
            FileOutputStream fout = new FileOutputStream(f.getPath().replaceAll("media", "lists") + "/"+"image_list.js");

        File filesList = new File(relative_path_file );
        if(f.exists()) {
        String[] files = filesList.list();
        String content = "var tinyMCEImageList = new Array(\n" +
                        "\t// Name, URL\n";
        for(int i=0; i<files.length; i++) {
            if(files[i].endsWith("png") || files[i].endsWith("jpg") || files[i].endsWith("JPG") || files[i].endsWith("jpeg") || files[i].endsWith("gif"))
                content += "\t[\""+ files[i] + "\", \"media/" + files[i] + "\"],\n";
        }

            if(pvalue.endsWith("png") || pvalue.endsWith("jpg") || pvalue.endsWith("JPG") || pvalue.endsWith("jpeg") || pvalue.endsWith("gif"))
            content += "\t[\""+ pvalue + "\", \"media/" + pvalue + "\"]\n";

            content +=  ");";

//            fout.write(("var tinyMCEImageList = new Array(\n" +
//                        "\t// Name, URL\n" +
//                        "\t[\"Logo 1\", \"media/logo.jpg\"],\n" +
//                        "\t[\"Logo 2 Over\", \"media/logo_over.jpg\"]\n" +
//                        ");").getBytes());
            fout.write(content.getBytes());
            fout.close();
        }
            absolute_path_file = f.getPath() + /*File.separator */ "/" + pvalue;
            System.err.println("saving file to: " + absolute_path_file);
            fout = new FileOutputStream(absolute_path_file);
//			out.println("<BR>File will be saved as:<BR> ");
//			out.println("<A HREF=\"" + uploadDir + File.separator + pvalue + "\">" + pvalue + "</a><BR>");

            bw = new BufferedOutputStream(fout); // output file...
            count = readLine(br, buffer, 0, buffer.length); // read the line with "Content-Type" (IE) or a empty one (Netscape)
            aux = new String(buffer, 0, count);
            if (aux.startsWith("Content-Type")) {
                count = readLine(br, buffer, 0, buffer.length); //read a empty line
                aux = new String(buffer, 0, count);
            } else {
//				out.println("<P>getFileFromStream(): WARNING - line must begin with 'Content-Type'!</P>");
                System.err.println("UploadServlet::getFileFromStream(): WARNING - line must begin with 'Content-Type'!");
            }
            if (aux.length() > 2) { // must be empty
                bw.write(new String("getFileFromStream(): ERROR - line must be empty!").getBytes());
                System.err.println("UploadServlet::getFileFromStream(): ERROR - line must be empty!");
                System.err.println("but the line is:" + aux);
//				out.println("getFileFromStream(): ERROR - line must be empty!<br>");
//				out.println("but the line is:"+ aux);
                bw.flush(); bw.close(); bw = null;
                return null;
            }
            int first_line_length = first_line.length();
            try {
                count = 0;
                byte[] last_line = new byte[BUFFER_SIZE];
                int last_count = 0;
                boolean endsEnter = false;
                while (true) {//count != -1) {
                    count = readLine(br, buffer, 0, BUFFER_SIZE);
                    if (count != -1) {
                        String aa = new String(buffer, 0, count);
                        if (aa.startsWith(first_line)) {
                            if (last_count != 0) {
                                bw.write(last_line, 0, last_count - 2);
                                if (last_line[last_count - 2] != '\r') {
                                    bw.write(last_line[last_count - 2]);
                                }
                            }
                            bw.flush();  bw.close();
                            return aa;
                            //break;
                        } else if (endsEnter) {
                            bw.write(last_line, 0, last_count);
                            last_count = 0;
                            endsEnter = false;
                        }
                        if (buffer[count-1] == '\n') {
                            System.arraycopy(buffer, 0, last_line, 0, count);
                            endsEnter = true;
                            last_count = count;
                            continue;
                        }
                        bw.write(buffer, 0, count);
                        //out.print(".");
                    } else {
//						out.println("<BR>count is -1<BR>");
                        break;
                    }
                }

///// parsing ////////////
//                    File destFile = new File(InitServlet.processedUploads+File.separator + f);



            } catch (Exception e) {
                System.err.println("UploadServlet::getFileFromStream(): error transfering file data: " + e);
                e.printStackTrace(System.err);
            } finally {
                bw.flush(); bw.close();
            }
//			out.println("<>count = " + count);
            return new String(buffer, 0, count);
        }
        return new String(s);

    }//end getFileNameFromStream()

    private void getParamFromStream(String s) throws IOException {
        String aux = s;
        int p1 = aux.indexOf("name=");
        int p2 = aux.lastIndexOf("\"");
        String pname = aux.substring(p1 + 6, p2);
        int count = readLine(br, buffer, 0, buffer.length); // read a empty line
        aux = new String(buffer, 0, count);
        if (aux.length() > 2) { // must be empty
            throw new IOException(new String("getParamFromStream(): ERROR - line must be empty!"));
        }
        count = readLine(br, buffer, 0, buffer.length);
        if (count == -1) {
            return;
        }
        String pvalue = new String(buffer, 0, count); // read the param value
        pvalue = pvalue.trim();
        p_names.addElement(pname);
        p_values.addElement(pvalue);
    }//end getParamFromStream()

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
    }//end readLine()
%>
