package com.toy.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodToyTest {

    @Test
    void testGoodToyConstructorWithoutId() {
        // Arrange & Act
        GoodToy goodToy = new GoodToy("LEGO City", true, "LEGO", 8, "Construcción");

        // Assert
        assertEquals("LEGO City", goodToy.getTitle());
        assertTrue(goodToy.isGoodToy);
        assertEquals("LEGO", goodToy.getBrand());
        assertEquals(8, goodToy.getTargetAge());
        assertEquals("Construcción", goodToy.getCategory());
    }

    @Test
    void testGoodToyConstructorWithId() {
        // Arrange & Act
        GoodToy goodToy = new GoodToy("G1", "LEGO Friends", true, "LEGO", 10, "Aventura");

        // Assert
        assertEquals("G1", goodToy.getId());
        assertEquals("LEGO Friends", goodToy.getTitle());
        assertTrue(goodToy.isGoodToy);
        assertEquals("LEGO", goodToy.getBrand());
        assertEquals(10, goodToy.getTargetAge());
        assertEquals("Aventura", goodToy.getCategory());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        GoodToy goodToy = new GoodToy("LEGO City", true, "LEGO", 8, "Construcción");

        // Act
        goodToy.setTitle("LEGO Technic");
        goodToy.setBrand("Technic");
        goodToy.setTargetAge(12);
        goodToy.setCategory("Engineering");

        // Assert
        assertEquals("LEGO Technic", goodToy.getTitle());
        assertEquals("Technic", goodToy.getBrand());
        assertEquals(12, goodToy.getTargetAge());
        assertEquals("Engineering", goodToy.getCategory());
    }
}

