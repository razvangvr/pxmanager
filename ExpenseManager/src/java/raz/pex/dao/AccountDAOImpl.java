/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.dao;

import raz.pex.beans.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static raz.pex.dao.Constants.*;

/**
 *
 * @author razvan
 */
public class AccountDAOImpl implements AccountDAO {

    private static final String INSER_ACCOUNT = "INSERT INTO account (IdAccount,IdUser,debit,credit) VALUES (NULL,?,?,?)";
    private static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM account WHERE account.IdAccount = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE account SET IdUser = ?, debit = ?, credit = ? WHERE IdAccount = ?";

    /**
     * Inserts an account into DB
     * @return the ID of newly created account
     * -1 on error
     */
    public int insertAccount(AccountBean account) {
        int result = SQL_ERR;
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(INSER_ACCOUNT);
            pstat.setLong(1, account.getIdUser());
            pstat.setFloat(2, account.getDebit());
            pstat.setFloat(3, account.getCredit());
            result = pstat.executeUpdate();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }
        return result;

    }

    /**
     * Find a Account by IdAccount
     * @param IdAccount
     * @return AccountBean, or returns null is no user has been ferched by specified Id
     */
    public AccountBean findAccountById(long idAccount) {
        AccountBean result = null;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(FIND_ACCOUNT_BY_ID);
            pstat.setLong(1, idAccount);
            rs = pstat.executeQuery();
            if (rs.next()) {
                result = new AccountBean();
                result.setIdAccount(rs.getLong("IdAccount"));
                result.setIdUser(rs.getLong("IdUser"));
                result.setDebit(rs.getFloat("debit"));
                result.setCredit(rs.getFloat("credit"));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }
        return result;
    }

    /**
     * Updates an Account
     * number of affected rows: > 0 (1) - if update was successful;
     * @return true if success, false on error
     */
    public boolean updateAccount(AccountBean account) {
        if (account == null) {
            throw new IllegalArgumentException("account can not be null");
        }
        int queryResult = SQL_ERR;
        boolean result = false;
        Long id = account.getIdAccount();
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(UPDATE_ACCOUNT);
            pstat.setLong(1, account.getIdUser());
            pstat.setFloat(2, account.getDebit());
            pstat.setFloat(3, account.getCredit());
            pstat.setLong(4, id);
            queryResult = pstat.executeUpdate();
            if (queryResult > 0) {
                result = true;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }
        return result;

    }

    public boolean deleteAccount(long idAccount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
