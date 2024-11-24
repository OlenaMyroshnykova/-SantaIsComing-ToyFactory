package com.toy.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.toy.models.BadToy;

public class BadToyDatabase implements IDatabase<BadToy> {

    private List<BadToy> badToys;

    public BadToyDatabase() {
        //System.out.println("BadToyDatabase instance created at: " + Thread.currentThread().getStackTrace()[2]);
        initDB();
    }

    public List<BadToy> getToys() {
        return badToys;
    }

    public void save(BadToy toy) {
        badToys.add(toy);
        System.out.println("bad toy added");
    }

    private void initDB() {
        this.badToys = new ArrayList<>(Arrays.asList(
                new BadToy("M1", "Mystery Box 5x5", true, "carbón")));
    }

}
