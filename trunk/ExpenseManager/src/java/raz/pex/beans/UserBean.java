/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.beans;

/**
 *
 * @author razvan
 * is it a TransferObject/Entity ?!
 */
public class UserBean implements java.io.Serializable {

    private long idUser;
    private String name;
    private String password;

    public UserBean(long idUser, String name, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }

    public UserBean() {
    }

    /**
     * @return the idUser
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
