/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.ExcelFileDemo.Model;

/**
 *
 * @author rv
 */
public class ExcelModel {

    private long id;
    private String emailid;
    private String password;
    private int role;

    public ExcelModel() {
    }

    public ExcelModel(long id, String emailid, String password, int role) {
        this.id = id;
        this.emailid = emailid;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
