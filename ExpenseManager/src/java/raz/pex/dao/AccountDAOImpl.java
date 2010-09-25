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

/**
 *
 * @author razvan
 */
public class AccountDAOImpl implements AccountDAO {

    private static final String INSER_ACCOUNT = "INSERT INTO account (IdAccount,IdUser,debit,credit) VALUES (NULL,?,?,?)";

    /**
     * Inserts an account into DB
     * @return the ID of newly created account
     * -1 on error
     */
    public int insertAccount(AccountBean account) {
        int result = Constants.SQL_ERR;
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

    public AccountBean findAccountById(long idAccount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean updateAccount(AccountBean account) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteAccount(long idAccount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
