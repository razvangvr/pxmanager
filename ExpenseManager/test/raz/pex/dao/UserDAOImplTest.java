/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raz.pex.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import raz.pex.beans.UserBean;

/**
 *
 * @author razvan
 */
public class UserDAOImplTest {

    public UserDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insertUser method, of class UserDAOImpl.
     */
    @Test
    public void testInsertUser() {
        System.out.println("insertUser");
        UserBean user = null;
        UserDAOImpl instance = new UserDAOImpl();
        int expResult = 0;
        int result = instance.insertUser(user);
        assertEquals(expResult, result);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUserById method, of class UserDAOImpl.
     */
    @Test
    public void testFindUserById() {
        System.out.println("findUserById");
        long idUser = 0L;
        UserDAOImpl instance = new UserDAOImpl();
        UserBean expResult = null;
        UserBean result = instance.findUserById(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserDAOImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        UserBean user = null;
        UserDAOImpl instance = new UserDAOImpl();
        boolean expResult = false;
        boolean result = instance.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDAOImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        long idUser = 0L;
        UserDAOImpl instance = new UserDAOImpl();
        boolean expResult = false;
        boolean result = instance.deleteUser(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}