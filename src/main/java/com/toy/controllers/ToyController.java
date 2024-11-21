package com.toy.controllers;

import com.toy.dtos.BadToyDto;
import com.toy.dtos.GoodToyDto;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.repository.ToyRepository;
import com.toy.singletons.ToyRepositorySingleton;
import com.toy.views.ElfView;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = ToyRepositorySingleton.getInstance();
    }

    public void postGoodToy(GoodToyDto goodToyDto) {
        // hará algo con el repositorio
        // si todo ha ido bien devolverá la respuesta
        GoodToy toy = new GoodToy(goodToyDto.title(), "Good", goodToyDto.brand(), goodToyDto.recommendedAge(), goodToyDto.category());
        repository.setDB("good_toy");
        repository.saveGoodToy(toy);
        ElfView.addToyResponse();
    }

    public void postBadToy(BadToyDto badToyDto) {
        BadToy toy = new BadToy(badToyDto.title(), "Bad", badToyDto.content());
        repository.setDB("bad_toy");
        repository.saveBadToy(toy);
        ElfView.addToyResponse();
    }

}