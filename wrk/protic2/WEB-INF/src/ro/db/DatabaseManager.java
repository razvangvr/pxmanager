package ro.db;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;


/**
 * This class implements a database manager used to handle pooling and database connections
 * <p/>
 *
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 23, 2004
 */

public class DatabaseManager {

    //---------------------------------------------------------//
    //                        CONSTANTS                        //
    //---------------------------------------------------------//
    private static final String connPrefix = "Connection.";

    private static  String PARAM_DATABASE_DRIVER = "org.gjt.mm.mysql.Driver";
    private static  String PARAM_DATABASE_URL = "jdbc:mysql://localhost:3306/dirigentie";
    private static  String PARAM_DATABASE_USER = "root";
    private static  String PARAM_DATABASE_PASSWORD = "root";
//	private static final String PARAM_DATABASE_MAX_ACTIVE = "database.maxActive";
//	private static final String PARAM_DATABASE_MAX_IDLE = "database.maxIdle";
//	private static final String PARAM_DATABASE_MAX_WAIT = "database.maxWait";
//
    private static  int DEFAULT_MAX_WAIT = 10000;
    private static  int DEFAULT_MAX_IDLE = 30;
    private static  int DEFAULT_MAX_ACTIVE = 100;

    //---------------------------------------------------------//
    //                         STATIC FIELDS                   //
    //---------------------------------------------------------//

    private static BasicDataSource dataSource;  // database source

    //---------------------------------------------------------//
    //                      CONSTRUCTORS                       //
    //---------------------------------------------------------//

    /**
     * Default prvate constructor used to disable multiple copies of this class
     */
    private DatabaseManager () {
    }

    //---------------------------------------------------------//
    //                         STATIC METHODS                  //
    //---------------------------------------------------------//

    /**
     * Initialize the database manager
     *
     */
    public static void init(Properties props){
        if (props!=null) {
            PARAM_DATABASE_DRIVER = props.getProperty(connPrefix + "driver").trim();
            PARAM_DATABASE_USER =  props.getProperty(connPrefix + "user");
            PARAM_DATABASE_PASSWORD = props.getProperty(connPrefix + "password");
            PARAM_DATABASE_URL =  props.getProperty(connPrefix + "url");
//              DEFAULT_MAX_ACTIVE  =
//				DEFAULT_MAX_IDLE =
//				DEFAULT_MAX_WAIT =
        }
        init();

    }//end initPool()
    public static void init () {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(PARAM_DATABASE_DRIVER);
        ds.setUsername(PARAM_DATABASE_USER);
        ds.setPassword(PARAM_DATABASE_PASSWORD);
        ds.setUrl(PARAM_DATABASE_URL);
        ds.setMaxActive((int)DEFAULT_MAX_ACTIVE);
        ds.setMaxIdle((int)DEFAULT_MAX_IDLE);
        ds.setMaxWait((int)DEFAULT_MAX_WAIT);
        dataSource = ds;

        Connection con = null;
        try {
            con = getConnection();
            DatabaseMetaData metadata = con.getMetaData();
            System.out.println("[DATABASE MANAGER] - Initialized, Database [" + metadata.getDatabaseProductName() + ", " + metadata.getDatabaseProductVersion() + "] Driver [" + metadata.getDriverName() + ", " + metadata.getDriverVersion() + "]");
        } catch (Exception ex) {
            System.out.println("Invalid database connection"+ ex);
            throw new RuntimeException("Invalid database connection", ex);
        } finally {
            ro.generic.util.DatabaseUtil.close(con, null, null);
        }
    }

    /**
     * Close all the connections
     */
    public static void close () {
        try {
            dataSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new connection to the database
     *
     * @return new created connection
     * @throws SQLException
     */
    public static Connection getConnection () throws SQLException {
        return dataSource.getConnection();
    }

}
