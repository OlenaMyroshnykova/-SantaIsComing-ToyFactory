package com.toy.singletons;

import com.toy.repository.ToyRepository;

public class ToyRepositorySingleton {

    private static final ToyRepository INSTANCE = new ToyRepository();

    private ToyRepositorySingleton() {}

    public static ToyRepository getInstance() {
        return INSTANCE;
    }

}
