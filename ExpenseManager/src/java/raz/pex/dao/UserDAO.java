/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.dao;

import raz.pex.beans.UserBean;

/**
 *
 * @author razvan
 */
public interface UserDAO {

    /**
     * Create
     */
    public int insertUser(UserBean user);

    /**
     * Read
     */
    public UserBean findUserById(long idUser);

    /**
     * Update
     */
    public boolean updateUser(UserBean user);

    /**
     * Delete
     */
    public boolean deleteUser(long idUser);
}
