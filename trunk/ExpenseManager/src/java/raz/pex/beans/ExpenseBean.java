/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raz.pex.beans;

import java.util.Date;

/**
 *
 * @author razvan
 */
public class ExpenseBean implements java.io.Serializable {

    private long idExpense;
    private long idUser;
    private long idAccount;
    private long idCategory;
    private Date date;
    private String description;
    private float amount;

    public ExpenseBean() {
    }

    public ExpenseBean(long idExpense, long idUser, long idAccount, long idCategory, Date date, String description, float amount) {
        this.idExpense = idExpense;
        this.idUser = idUser;
        this.idAccount = idAccount;
        this.idCategory = idCategory;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    /**
     * @return the idExpense
     */
    public long getIdExpense() {
        return idExpense;
    }

    /**
     * @param idExpense the idExpense to set
     */
    public void setIdExpense(long idExpense) {
        this.idExpense = idExpense;
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
     * @return the idCategory
     */
    public long getIdCategory() {
        return idCategory;
    }

    /**
     * @param idCategory the idCategory to set
     */
    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
