package ro.servlets.init;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * <p>Title: Information System Improvement (ISI) Project
 * <p>Description: Business Activity Management </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @version 1.0
 */

import java.beans.PropertyEditorManager;

public class ContextListenerProp extends HttpServlet implements ServletContextListener {
        private ServletContext context = null;


        //Notification that the servlet context is about to be shut down
        public void contextDestroyed(ServletContextEvent sce) {
                context.log("ContextListenerProp: contextDestroyed()");
                context = null;
        }

        //Notification that the web application is ready to process requests
        public void contextInitialized(ServletContextEvent event) {
                context = (ServletContext) event.getSource();
                System.out.println("ContextListenerProp: contextInitialized()");
//                PropertyEditorManager.registerEditor(java.math.BigDecimal.class,
//                                                     ro.sam.beans.property.BigDecimalPropertyEditor.class);
//                PropertyEditorManager.registerEditor(java.sql.Date.class,
//                                                     ro.sam.beans.property.DataPropertyEditor.class);
//                PropertyEditorManager.registerEditor(java.sql.Timestamp.class,
//                                                 ro.sam.beans.property.TimestampPropertyEditor.class);

                System.out.println("ContextListenerProp: getEditorSearchPath() -->");
                String search[] = PropertyEditorManager.getEditorSearchPath();
                if (search == null)
                    search = new String[0];
                for (int i = 0; i < search.length; i++)
                    System.out.println("ContextListenerProp:   " + search[i]);
                System.out.println("ContextListenerProp: findEditor() --> " +
                        PropertyEditorManager.findEditor(java.math.BigDecimal.class));
                System.out.println("ContextListenerProp: findEditor() --> " +
                        PropertyEditorManager.findEditor(java.sql.Date.class));
                System.out.println("ContextListenerProp: findEditor() --> " +
                    PropertyEditorManager.findEditor(java.sql.Timestamp.class));

        }
}