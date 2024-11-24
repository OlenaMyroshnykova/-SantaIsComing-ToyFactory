package com.toy.views;

import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.repository.ToyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ElfViewTest {

    private ByteArrayOutputStream outContent;

    @Test
    void testDisplayAllToysEmpty() {
        String simulatedInput = "2\n4\n"; // Выбор "Ver todos los juguetes" и "Cerrar sesión"
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ElfView.menu();

        String output = outContent.toString();
        assertTrue(output.contains("No hay juguetes en el inventario."));
    }

    @Test
    void testAddGoodToyAndDisplay() {
        String simulatedInput = "1\n1\nLEGO City\nLEGO\n8\nConstrucción\n2\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ElfView.menu();

        String output = outContent.toString();
        assertTrue(output.contains("Buen juguete - ID:"));
        assertTrue(output.contains("LEGO City"));
    }

    @Test
    void testAddBadToyAndDisplay() {
        String simulatedInput = "1\n2\nMystery Box\nCarbón\n2\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ElfView.menu();

        String output = outContent.toString();
        assertTrue(output.contains("Mal juguete - ID:"));
        assertTrue(output.contains("Mystery Box"));
    }

    @Test
    void testDeleteToy() {
        ToyRepository toyRepository = new ToyRepository();
        GoodToy goodToy = new GoodToy("LEGO City", true, "LEGO", 8, "Construcción");
        toyRepository.saveGoodToy(goodToy);

        String simulatedInput = "3\n" + goodToy.getId() + "\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ElfView.menu();

        String output = outContent.toString();
        assertTrue(output.contains("Juguete eliminado con éxito."));
        assertTrue(toyRepository.getGoodToys().isEmpty());
    }

    @Test
    void testDeleteNonExistentToy() {
        String simulatedInput = "3\nNonExistentID\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ElfView.menu();

        String output = outContent.toString();
        assertTrue(output.contains("No se pudo eliminar el juguete. Verifique el ID."));
    }
}


