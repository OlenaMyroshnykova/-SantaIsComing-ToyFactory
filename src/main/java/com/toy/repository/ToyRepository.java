package com.toy.repository;

import com.toy.db.IDatabase;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.singletons.BadToyDatabaseSingleton;
import com.toy.singletons.GoodToyDatabaseSingleton;

@SuppressWarnings("rawtypes")
public class ToyRepository {

    private IDatabase db;

    public void setDB(String type) {
        // setter injection
        if (type == "good_toy")
            this.db = GoodToyDatabaseSingleton.getInstance();

        if (type == "bad_toy")
            this.db = BadToyDatabaseSingleton.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void saveGoodToy(GoodToy toy) {
        db.save(toy);
    }

    @SuppressWarnings("unchecked")
    public void saveBadToy(BadToy toy) {
        db.save(toy);
    }

}
