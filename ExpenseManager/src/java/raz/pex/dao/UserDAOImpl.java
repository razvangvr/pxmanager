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
    private static final String INSERT_USER = "INSERT INTO users (IdUser,name,password) VALUES (NULL,?,?);";
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE users.IdUser = ?;";
    private static final String UPDATE_USER = "UPDATE users SET name = ?, password = ? WHERE IdUser = ?;";
    private static final String DELETE_USER = "DELETE FROM users WHERE userId=?;";

    /**
     * Inserts an user into DB
     * @return the ID of newly created customer
     * -1 on error
     */
    public int insertUser(UserBean user) {
        if (user == null) {
            throw new IllegalArgumentException("user can not be null");
        }
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
            DAOFactoryMySQL.closeConnection(conn);
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
            DAOFactoryMySQL.closeConnection(conn);
        }
        return result;
    }

    /**
     * updates this user
     * @return true on success. false on error or failure
     * @return nr de randuri afectate: > 0 (1) - daca schimbarea s-a facut cu succes;
     * 0 - in cazul in care nici un rand nu a fost afectat;
     * -1 - in cazul unei erori.
     */
    public boolean updateUser(UserBean user) {
        if (user == null) {
            throw new IllegalArgumentException("user can not be null");
        }
        int queryResult = SQL_ERR;
        boolean result = false;
        Long id = user.getIdUser();
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(UPDATE_USER);
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getPassword());
            pstat.setLong(3, id);
            queryResult = pstat.executeUpdate();
            if(queryResult>0){
                result = true;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }
        return result;
    }

    /**
     * Deletes the user with the giver IdUser
     * TODO - if I delete a user then I can create an inconsitency in the DB
     * what happens with the accounts and expenses of an user when you delete it?
     * before you can delete an user you should check that is has no accounts/expenses
     * @return true on success. false on error or failure
     */
    public boolean deleteUser(long idUser) {
        boolean result = false;
        int queryResult = SQL_ERR;
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(DELETE_USER);
            pstat.setLong(1, idUser);
            queryResult = pstat.executeUpdate();
            if(queryResult>0){
                result = true;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }

        return result;
        
    }
}
