package com.toy.models;

public class BadToys extends Toy {

    private String content;

    public BadToys(String title, String toyType, String content) {
        super(title, toyType);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
