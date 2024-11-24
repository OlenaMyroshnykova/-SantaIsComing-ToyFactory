package com.toy.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadToyTest {

    @Test
    void testBadToyConstructorWithoutId() {
        // Arrange & Act
        BadToy badToy = new BadToy("Mystery Box", false, "Coal");

        // Assert
        assertEquals("Mystery Box", badToy.getTitle());
        assertFalse(badToy.isGoodToy);
        assertEquals("Coal", badToy.getContent());
    }

    @Test
    void testBadToyConstructorWithId() {
        // Arrange & Act
        BadToy badToy = new BadToy("B1", "Broken Toy", false, "Shards");

        // Assert
        assertEquals("B1", badToy.getId());
        assertEquals("Broken Toy", badToy.getTitle());
        assertFalse(badToy.isGoodToy);
        assertEquals("Shards", badToy.getContent());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        BadToy badToy = new BadToy("Old Toy", false, "Dust");

        // Act
        badToy.setTitle("Haunted Toy");
        badToy.setContent("Ghosts");

        // Assert
        assertEquals("Haunted Toy", badToy.getTitle());
        assertEquals("Ghosts", badToy.getContent());
    }
}

