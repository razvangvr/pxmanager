package jug.converter.client;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jug.converter.api.CurrencyConverterRemote;


public class EjbClient {
	
	static CurrencyConverterRemote converter;
	
	
	public static void main(String[] args){
		try {
			
			//Just to make sure the properties file is in classpath
			ResourceBundle bundle = ResourceBundle.getBundle("jboss-ejb-client");
			System.out.println("port:"+bundle.getString("remote.connection.default.port"));
			
			converter = (CurrencyConverterRemote) lookupBean();
			System.out.println("Bean Proxy HashCode:"+converter.hashCode());
			BigDecimal eur = new BigDecimal(10);
			BigDecimal eurToRon = converter.convertEuroToRon(eur);
			System.out.println("Eur to Ron:"+eurToRon);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * looks up and returns a proxy to the remote bean
	 * https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI
	 * http://javahowto.blogspot.ro/2012/05/standalone-java-client-for-jboss-as-711.html
	 * */
	private static Object lookupBean() throws NamingException{
		 /*
         * The app name is the application name of the deployed EJBs. This is typically the ear name without the .ear suffix.
         * However, the application name could be overridden in the application.xml of the EJB deployment on the server. Since
         * we haven't deployed the application as a .ear, the app name for us will be an empty string
         */
        final String appName = "jug-stateless-converter-ear";
        
        /*
         * This is the module name of the deployed EJBs on the server. This is typically the jar name of the EJB deployment,
         * without the .jar suffix, but can be overridden via the ejb-jar.xml. In this example, we have deployed the EJBs in a
         * jboss-as-shoppingcart-server.jar, so the module name is jboss-as-shopping-cart-server
         */
        final String moduleName = "jug-stateless-converter-ejb";
        
        /*
         * AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for our EJB
         * deployment, so this is an empty string
         */
        final String distinctName = "";
        
        /*
         * The EJB name which by default is the simple class name of the bean implementation class
         */
        final String beanName = CurrencyConverterRemote.BEAN_NAME;
        
        /* The remote view fully qualified class name */
        final String viewClassName = CurrencyConverterRemote.class.getName();
        
        String lookupName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + beanName + "!" + viewClassName;
		
		
		Object obj = null;
		final Hashtable jndiProperties = new Hashtable();

        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        final Context context = new InitialContext(jndiProperties);
        
        /* Lookup the remote interface */
        obj = context.lookup(lookupName);
        
        
		return obj;
	}

}
