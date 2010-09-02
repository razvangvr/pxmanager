/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package raz.pex.beans;

/**
 *
 * @author razvan
 */
public class CategoryBean implements java.io.Serializable{

    private long idCategory;
    private String name;
    private String description;

    public CategoryBean(long idCategory, String name, String description) {
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    




}
