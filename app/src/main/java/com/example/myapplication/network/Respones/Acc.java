package com.example.myapplication.network.Respones;

public class Acc {
    private int id;
    private String name;
    private String pass;
    private String add;
    private String old;
    private String email;

    public String getEmail() {
        return email;
    }

    public Acc(String name, String pass, String add, String old, String email) {
        this.name = name;
        this.pass = pass;
        this.add = add;
        this.old = old;
        this.email = email;
    }

    public Acc(int id, String name, String pass, String add, String old, String email) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.add = add;
        this.old = old;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

}
