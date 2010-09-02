/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.beans;

/**
 *
 * @author razvan
 *
 * is it just a Transfer Object ?
 */
public class AccountBean implements java.io.Serializable{

    private long idAccount;
    private long idUser;
    private float debit;
    private float credit;

    public AccountBean(long idAccount, long idUser, float debit, float credit) {
        this.idAccount = idAccount;
        this.idUser = idUser;
        this.debit = debit;
        this.credit = credit;
    }

    /**
     * @return the idAccount
     */
    public long getIdAccount() {
        return idAccount;
    }

    /**
     * @param idAccount the idAccount to set
     */
    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
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
     * @return the debit
     */
    public float getDebit() {
        return debit;
    }

    /**
     * @param debit the debit to set
     */
    public void setDebit(float debit) {
        this.debit = debit;
    }

    /**
     * @return the credit
     */
    public float getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(float credit) {
        this.credit = credit;
    }
}
