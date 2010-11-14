/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raz.pex.dao;

import raz.pex.beans.ExpenseBean;

/**
 *
 * @author razvan
 */
public interface ExpenseDAO {

     /**
     * Create
     */
    public int insertExpense(ExpenseBean expense);

    /**
     * Read
     */
    public ExpenseBean findExpenseById(long idExpense);

    /**
     * Update
     */
    public boolean updateExpense(ExpenseBean expense);

    /**
     * Delete
     */
    public boolean deleteExpense(long idExpense);

}
