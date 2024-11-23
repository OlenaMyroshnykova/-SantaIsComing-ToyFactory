package com.toy.repository;

import java.util.ArrayList;
import java.util.List;

import com.toy.db.BadToyDatabase;
import com.toy.db.GoodToyDatabase;
import com.toy.db.IDatabase;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.singletons.BadToyDatabaseSingleton;
import com.toy.singletons.GoodToyDatabaseSingleton;

@SuppressWarnings("rawtypes")
public class ToyRepository {

    private IDatabase db;
    private final GoodToyDatabase goodToyDatabase = new GoodToyDatabase();
    private final BadToyDatabase badToyDatabase = new BadToyDatabase();    

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

    public List<Object> getAllToys() {
        List<Object> allToys = new ArrayList<>();

        // Получаем игрушки из базы хороших игрушек
        List<GoodToy> goodToys = goodToyDatabase.getToys();
        allToys.addAll(goodToys);

        // Получаем игрушки из базы плохих игрушек
        List<BadToy> badToys = badToyDatabase.getToys();
        allToys.addAll(badToys);

        return allToys;
    }

}
