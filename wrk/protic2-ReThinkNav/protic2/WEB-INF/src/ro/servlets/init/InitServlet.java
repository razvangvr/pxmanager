package ro.servlets.init;

/**
 * <p>Title: Information System Improvement (ISI) Project
 * <p>Description: Business Activity Management </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author
 * @version 1.0
 */

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitServlet extends HttpServlet {

    
    public static String APP_HOME = "";

    public static String tempreportsdir = "/home/agricol";
    public static String uploadsdir = "/home/processedUploads";
    public static String processedUploads = "processed";
    public static String resources = "";

    public void init(ServletConfig conf) throws ServletException {
            super.init(conf);

            Properties siteProps = new Properties();
            Enumeration initParameterNames = conf.getInitParameterNames();
            String initParameterName = null;
            while (initParameterNames.hasMoreElements()) {
                    initParameterName = (String)initParameterNames.nextElement();
                    siteProps.setProperty(initParameterName, conf.getInitParameter(initParameterName));
                initParameterName = null;
            }//end while()
            String prefix =  getServletContext().getRealPath("/");
            if(siteProps.getProperty("tempreports")!=null)
                tempreportsdir = siteProps.getProperty("tempreports");
            new File(tempreportsdir).mkdirs();

            if(siteProps.getProperty("resources")!=null)
                resources = siteProps.getProperty("resources");
            new File(resources).mkdirs();

           
            System.out.println("catalina.base>>>"+System.getProperty("catalina.base"));//http://www.mkyong.com/java/how-to-get-the-tomcat-home-directory-in-java/
            APP_HOME =  this.getServletContext().getRealPath("/");
            System.out.println("\nApp Deployed Directory path: " +APP_HOME);//http://crunchify.com/how-to-get-tomcat-directory-path-in-java/
            if(siteProps.getProperty("uploads")!=null)
                uploadsdir = siteProps.getProperty("uploads");
            File uploadDir = new File(APP_HOME,uploadsdir);
            System.out.println(">>"+uploadDir.getAbsolutePath());
            uploadDir.mkdirs();
           
            
            if(siteProps.getProperty("processedUploads")!=null)
                processedUploads = prefix + siteProps.getProperty("processedUploads");
            new File(processedUploads).mkdirs();

            String file = "WEB-INF" + File.separator + "log4j.ini";
            // if the log4j-init-file is not set, then no point in trying
//	            if(file != null) {
//	              PropertyConfigurator.configure(prefix+file);
//	            }
            System.out.println("-> " + prefix + file);

            String logFile = siteProps.getProperty("logfile").trim();


            try {
                ro.db.DatabaseManager.init(siteProps);
                } catch (Exception exc) {
                exc.printStackTrace();
                return;
            }


//            Thread h = new Thread(new ProcessorThread());
//            h.start();

    }//end init()

    public void destroy() {
          super.destroy();
    }//end destroy()

}//end class InitServlet
