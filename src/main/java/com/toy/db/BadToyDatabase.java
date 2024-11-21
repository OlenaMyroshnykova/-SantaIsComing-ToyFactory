package com.toy.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.toy.models.BadToy;

public class BadToyDatabase implements IDatabase<BadToy> {

    private List<BadToy> badToys;

    public BadToyDatabase() {
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
        this.badToys = new ArrayList<>(Arrays.asList(new BadToy("Mystery Box 5x5", "Bad", "carbón")));
    }

}
