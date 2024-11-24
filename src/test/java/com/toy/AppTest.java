package com.toy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    public void testAppConstructorInit() {
        App app = new App(); 
        assertNotNull(app); 
    }

     @Test
    void testMainWithElfOption() {
        String simulatedInput = "1\n4\n3\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inContent);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("1. Elfo"));
        assertTrue(output.contains("2. Santa Claus"));
        assertTrue(output.contains("Seleccione una opción:"));

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainWithSantaOption() {
        
        String simulatedInput = "2\n4\n3\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inContent);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("1. Elfo"));
        assertTrue(output.contains("2. Santa Claus"));
        assertTrue(output.contains("Seleccione una opción:"));

        System.setIn(System.in);
        System.setOut(System.out);
    }

}
