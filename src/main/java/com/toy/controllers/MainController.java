package com.toy.controllers;

import com.toy.views.MainView;

public class MainController {

    public MainController() {
        index();
    }

    public void index() {
        // responde con una vista
        MainView.start();
    }

}