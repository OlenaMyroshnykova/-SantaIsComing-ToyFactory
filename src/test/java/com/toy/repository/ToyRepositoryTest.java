package com.toy.repository;

import com.toy.controllers.ToyController;
import com.toy.dtos.BadToyDTO;
import com.toy.dtos.GoodToyDTO;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToyRepositoryTest {

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

    @Test
    void testSaveAllToysToCSV() throws IOException {
        final ToyController controller = new ToyController();
        final ToyRepository toyRepository = new ToyRepository();
        String filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "com", "toy", "repository", "Toys.csv").toString();

        boolean success = toyRepository.saveAllToysToCSV();
        assertTrue(success, "Archivo CSV guardado en:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerGood = reader.readLine();
            assertEquals("\"CATEGORÍA\",\"ID\",\"TIPO\",\"TÍTULO\"", headerGood, "Заголовок CSV должен быть корректным");

            String goodToyLine = reader.readLine();
            assertTrue(goodToyLine.contains("Batman"), "Данные хорошей игрушки должны быть в файле");

            String headerBad = reader.readLine();
            assertEquals("CONTENIDO,ID,TIPO,TÍTULO", headerBad, "Заголовок CSV должен быть корректным");
            
            String badToyLine = reader.readLine();
            assertTrue(badToyLine.contains("Mystery Box 5x5"), "Данные плохой игрушки должны быть в файле");
        }

    }
}
