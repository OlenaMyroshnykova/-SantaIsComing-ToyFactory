package com.toy;

import com.toy.views.MainView;
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
        // Подготовка: эмулируем ввод пользователя (выбираем "1" для Elfo)
        String simulatedInput = "1\n4\n3\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inContent);

        // Перехватываем вывод
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Запускаем метод main()
        App.main(new String[]{});

        // Проверяем, что в выводе есть текст меню
        String output = outContent.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("1. Elfo"));
        assertTrue(output.contains("2. Santa Claus"));
        assertTrue(output.contains("Seleccione una opción:"));

        // Восстанавливаем стандартные ввод/вывод
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainWithSantaOption() {
        // Подготовка: эмулируем ввод пользователя (выбираем "2" для Santa Claus)
        String simulatedInput = "2\n4\n3\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inContent);

        // Перехватываем вывод
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Запускаем метод main()
        App.main(new String[]{});

        // Проверяем, что в выводе есть текст меню
        String output = outContent.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("1. Elfo"));
        assertTrue(output.contains("2. Santa Claus"));
        assertTrue(output.contains("Seleccione una opción:"));

        // Восстанавливаем стандартные ввод/вывод
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testMainQuitOption() {
        // // Подготовка: эмулируем ввод пользователя (выбираем "3" для Salir)
        // String simulatedInput = "3\n";
        // ByteArrayInputStream inContent = new ByteArrayInputStream(simulatedInput.getBytes());
        // System.setIn(inContent);

        // // Перехватываем вывод
        // ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // System.setOut(new PrintStream(outContent));

        // // Запускаем метод main()
        // App.main(new String[]{});

        // // Проверяем, что программа завершилась корректно
        // String output = outContent.toString();
        // assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        // assertTrue(output.contains("Seleccione una opción:"));

        // // Восстанавливаем стандартные ввод/вывод
        // System.setIn(System.in);
        // System.setOut(System.out);
    }
}
