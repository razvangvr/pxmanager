/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author razvan
 * Singletone
 */
public class DAOFactoryMySQL {

    private static final String jdbcResource = "jdbc/expensemanager";
    private static DataSource dataSource = null;
    private static DAOFactoryMySQL instance = null;

    private DAOFactoryMySQL() {
    }

    public static DAOFactoryMySQL getInstance() {
        if (null == instance) {
            instance = new DAOFactoryMySQL();
        }
        return instance;
    }

    /**
     * Return a SQL Connection to the DB
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        if (null == dataSource) {
            //JNDI lookup
            //lookup my be costly, so do it once
            Context env = null;
            try {
                env = (Context) new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) env.lookup(jdbcResource);
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        conn = dataSource.getConnection();
        return conn;
    }

    /**
     * Close a connection.
     * It is important to close every connection after it has been used
     * 
     */
    public static void closeConnection(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException sqle1) {
                sqle1.printStackTrace();
            }
        }
    }

    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
}
