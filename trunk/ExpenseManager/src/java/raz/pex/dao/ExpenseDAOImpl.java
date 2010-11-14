/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import raz.pex.beans.ExpenseBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static raz.pex.dao.Constants.*;
import static raz.pex.util.Assert.*;
import raz.pex.dao.DAOFactoryMySQL;

/**
 *
 * @author razvan
 */
public class ExpenseDAOImpl implements ExpenseDAO {

    private static final String INSERT_EXPENSE = "INSERT INTO expenses (IdExpense, IdUser, IdAccount, IdCategory, date, description, amount) " +
            "VALUES (NULL,?,?,?,NOW(),?,?);";
    private static final String FIND_EXPENSE_BY_ID = "SELECT * FROM expenses WHERE IdExpense = ?; ";

    /**
     * Inserts an Expense into DB
     * @return the ID of newly created Expense
     * @return -1 on error
     */
    public int insertExpense(ExpenseBean expense) {
        int result = SQL_ERR;
        assertNotNull(expense, "Expense can not be null");
        Connection conn = null;
        PreparedStatement pstat = null;
        int count = 1;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(INSERT_EXPENSE);
            pstat.setLong(count++, expense.getIdUser());
            pstat.setLong(count++, expense.getIdAccount());
            pstat.setLong(count++, expense.getIdCategory());
            //pstat.setDate(count++,(Date) expense.getDate());
            //TODO: How to convert from java Date to SQL Date?
            pstat.setString(count++, expense.getDescription());
            pstat.setFloat(count++, expense.getAmount());
            result = pstat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }

        return result;
    }

    /**
     * Find an Expense by IdExpense
     * @param IdExpense
     * @return ExpenseBean, or null if no expense could be found by specified id
     */
    public ExpenseBean findExpenseById(long idExpense) {
        ExpenseBean result = null;
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn = DAOFactoryMySQL.getConnection();
            pstat = conn.prepareStatement(FIND_EXPENSE_BY_ID);
            pstat.setLong(1, idExpense);
            rs = pstat.executeQuery();
            if (rs.next()) {
                //result = new ExpenseBean(idExpense, idExpense, idExpense, idExpense, null, INSERT_EXPENSE, SQL_ERR);
//                result.setIdUser(rs.getLong("IdUser"));
//                result.setName(rs.getString("name"));
//                result.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DAOFactoryMySQL.closeConnection(conn);
        }

        return result;
    }

    public boolean updateExpense(ExpenseBean expense) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteExpense(long idExpense) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
