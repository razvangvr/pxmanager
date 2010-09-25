/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raz.pex.dao;

import raz.pex.beans.AccountBean;

/**
 *
 * @author razvan
 */
public interface AccountDAO {

    /**
     * Create
     */
    public int insertAccount(AccountBean account);

    /**
     * Read
     */
    public AccountBean findAccountById(long idAccount);

    /**
     * Update
     */
    public boolean updateAccount(AccountBean account);

    /**
     * Delete
     */
    public boolean deleteAccount(long idAccount);

}
