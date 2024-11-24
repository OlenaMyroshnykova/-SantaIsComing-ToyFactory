package com.toy.repository;

import com.toy.controllers.ToyController;
import com.toy.dtos.BadToyDTO;
import com.toy.dtos.GoodToyDTO;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToyRepositoryTest {

    private ToyRepository toyRepository;

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void testAddAndGetGoodToy() {
        final ToyController controller = new ToyController();
        final ToyRepository toyRepository = new ToyRepository();

        controller.postGoodToy(new GoodToyDTO("LEGO Star Wars", "brand", 8, "CAT"));
        
        List<GoodToy> goodToys = toyRepository.getGoodToys();
        assertEquals(2, goodToys.size()); // Должна быть одна игрушка
    }

    @Test
    void testAddAndGetBadToy() {
        final ToyController controller = new ToyController();
        final ToyRepository toyRepository = new ToyRepository();

        controller.postBadToy(new BadToyDTO("title", "content"));
        
        List<BadToy> goodToys = toyRepository.getBadToys();
        assertEquals(2, goodToys.size()); // Должна быть одна игрушка
    }

}
