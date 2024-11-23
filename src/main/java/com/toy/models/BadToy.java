package com.toy.models;

public class BadToy extends Toy {

    private String content;

    public BadToy(String title, boolean isGoodToy, String content) {
        super(title, isGoodToy);
        this.content = content;
    }

    public BadToy(String id, String title, boolean isGoodToy, String content) {
        super(id, title, isGoodToy);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
