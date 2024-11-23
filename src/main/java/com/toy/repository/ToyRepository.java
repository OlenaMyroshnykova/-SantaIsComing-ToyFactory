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
    private final GoodToyDatabase goodToyDatabase = GoodToyDatabaseSingleton.getInstance();
    private final BadToyDatabase badToyDatabase = BadToyDatabaseSingleton.getInstance();    

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

        List<GoodToy> goodToys = goodToyDatabase.getToys();
        allToys.addAll(goodToys);

        List<BadToy> badToys = badToyDatabase.getToys();
        allToys.addAll(badToys);

        return allToys;
    }

    public boolean deleteToyById(String id) {
        if (id.startsWith("B")) {
            return goodToyDatabase.getToys().removeIf(toy -> toy.getId().equals(id));
        }
        if (id.startsWith("M")) {
            return badToyDatabase.getToys().removeIf(toy -> toy.getId().equals(id));
        }

        System.out.println("No se pudo eliminar el juguete. Verifique el ID: " + id);
        return false;
    }

}
