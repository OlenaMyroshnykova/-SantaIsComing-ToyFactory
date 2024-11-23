package com.toy.models;

public class Toy {

    private static int idCounterGood = 2;
    private static int idCounterBad = 2;
    protected String id;
    protected String title;
    protected boolean isGoodToy;

    public Toy(String title, boolean isGoodToy) {
        this.title = title;
        this.isGoodToy = isGoodToy;
        if (isGoodToy) {
            setId(idCounterGood++);
        } else {
            setId(idCounterBad++);
        }
    }

    public Toy(String id, String title, boolean isGoodToy) {
        this.id = id;
        this.title = title;
        this.isGoodToy = isGoodToy;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        if (isGoodToy) {
            this.id = "B" + id;
        } else {
            this.id = "M" + id;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}