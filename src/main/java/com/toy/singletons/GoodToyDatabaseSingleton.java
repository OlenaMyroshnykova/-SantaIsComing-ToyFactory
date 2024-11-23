package com.toy.singletons;

import com.toy.db.GoodToyDatabase;

public class GoodToyDatabaseSingleton {

    private static GoodToyDatabase INSTANCE;

    private GoodToyDatabaseSingleton() {}

    public static GoodToyDatabase getInstance() {
        if (INSTANCE == null) INSTANCE = new GoodToyDatabase();
        return INSTANCE;
    }

}
