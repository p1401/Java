/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author duyph
 */
public class Category {
    private int categoryID;
    private String categoryName;

    public Category() {}
    
    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public int getcategoryID() {
        return categoryID;
    }

    public void setcategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getcategoryName() {
        return categoryName;
    }

    public void setcategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    @Override
    public String toString() {
        return "Category{" + "cid=" + categoryID + ", cname=" + categoryName + '}';
    }
}
