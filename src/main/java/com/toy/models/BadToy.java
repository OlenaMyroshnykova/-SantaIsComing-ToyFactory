package com.toy.models;

public class BadToy extends Toy {

    private String content;

    public BadToy(String title, String toyType, String content) {
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
