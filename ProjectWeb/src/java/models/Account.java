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
public class Account {
    private int id;
    private String user;
    private String pass;
    private boolean admin;

    public Account(int id, String user, String pass, boolean admin) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "account{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", adamin=" + admin + '}';
    }
    
}
