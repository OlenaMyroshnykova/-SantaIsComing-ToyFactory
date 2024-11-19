package com.toy.models;

public abstract class Toy {
    private int id;
    private String title;
    private String toyType;
    private static int idMax;

    public Toy(String title, String toyType) {
        this.id = idMax++;
        this.title = title;
        this.toyType = toyType;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getToyType() {
        return toyType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setToyType(String toyType) {
        this.toyType = toyType;
    }

}