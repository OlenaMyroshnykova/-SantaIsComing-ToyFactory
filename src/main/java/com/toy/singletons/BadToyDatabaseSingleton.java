package com.toy.singletons;

import com.toy.db.BadToyDatabase;

public class BadToyDatabaseSingleton {

    private static BadToyDatabase INSTANCE;

    private BadToyDatabaseSingleton() {}

    public static BadToyDatabase getInstance() {
        if (INSTANCE == null) INSTANCE = new BadToyDatabase();
        return INSTANCE;
    }
}
