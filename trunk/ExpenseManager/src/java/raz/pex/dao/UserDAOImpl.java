/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import raz.pex.beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author razvan
 */
public class UserDAOImpl implements UserDAO {

    public static final int SQL_ERR = -1;
    private static final String INSERT_USER = "INSERT INTO users (IdUser,name,password) VALUES (NULL,?,?)";
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE users.IdUser = ?";

    /**
     * Inserts an user into DB
     * @return the ID of newly created customer
     * -1 on error
     */
    public int insertUser(UserBean user) {
        int result = SQL_ERR;
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(INSERT_USER);
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getPassword());
            result = pstat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (null != conn) {
                DAOFactoryMySQL.closeConnection(conn);
            }
        }
        return result;

    }

    /**
     * Find a User by IdUser
     * @param IdUser
     * @return userBean, or returns null is no user has been ferched by specified IdUer
     */
    public UserBean findUserById(long idUser) {
        UserBean result = null;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(FIND_USER_BY_ID);
            pstat.setLong(1, idUser);
            rs = pstat.executeQuery();
            if (rs.next()) {
                result = new UserBean();
                result.setIdUser(rs.getLong("IdUser"));
                result.setName(rs.getString("name"));
                result.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (null != conn) {
                DAOFactoryMySQL.closeConnection(conn);
            }
        }
        return result;
    }

    public boolean updateUser(UserBean user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteUser(long idUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
