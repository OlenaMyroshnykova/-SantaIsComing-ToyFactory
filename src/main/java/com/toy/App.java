package com.toy;

import com.toy.controllers.MainController;
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        MainController.index();
    }
}
