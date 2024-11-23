package com.toy.views;

import java.util.List;

import com.toy.controllers.ToyController;
import com.toy.dtos.BadToyDTO;
import com.toy.dtos.GoodToyDTO;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.repository.ToyRepository;

public class ElfView extends View {

    private static final ToyController controller = new ToyController();
    private final static ToyRepository toyRepository = new ToyRepository();
    
        public static void menu() {
            System.out.println("-----------------------------------------");
            System.out.println("Gestor de juguetes (Tip de sessión: Elfo)");
            System.out.println("1. Añadir juguete");
            System.out.println("2. Ver todos los juguetes");
            System.out.println("4. Cerrar sesión");
            System.out.println("Seleccione una opción:");
    
            int option = scanner.nextInt();
    
            if (option == 1) selectChild();
            if (option == 2) displayAllToys();
            if (option == 4) closeSession();
        }
            
            
        public static void displayAllToys() {
            List<Object> allToys = toyRepository.getAllToys();

        if (allToys.isEmpty()) {
            System.out.println("No hay juguetes en el inventario.");
        } else {
            System.out.println("Lista de todos los juguetes:");
            for (Object toy : allToys) {
                if (toy instanceof GoodToy) {
                    GoodToy goodToy = (GoodToy) toy;
                    System.out.println("Good Toy - ID: " + goodToy.getId() + ", Título: " + goodToy.getTitle());// + ", Tipo: " + goodToy.getToyType());
                } else if (toy instanceof BadToy) {
                    BadToy badToy = (BadToy) toy;
                    System.out.println("Bad Toy - ID: " + badToy.getId() + ", Título: " + badToy.getTitle() + ", Contenido: " + badToy.getContent());
                }
            }
        }
    }

    public static void selectChild() {
        System.out.println("-----------------------------------------");
        System.out.println("Para niño ...:");
        System.out.println("1. Bueno");
        System.out.println("2. Malo");
        int option = scanner.nextInt();

        if (option == 1) postGoodToy();
        if (option == 2) postBadToy();
    }

    public static void postGoodToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el título:");
        String title = scanner.next();
        System.out.println("Ingrese la marca:");
        String brand = scanner.next();
        System.out.println("Ingrese la edad recomendada:");
        int age = scanner.nextInt();
        System.out.println("Ingrese la categoria:");
        String category = scanner.next();

        controller.postGoodToy(new GoodToyDTO(title, brand, age, category));
    }

    public static void postBadToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el título:");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Ingrese el contenido:");
        String content = scanner.nextLine();

        controller.postBadToy(new BadToyDTO(title, content));
    }

    public static void addToyResponse() {
        System.out.println("Juguete añadido con éxito");
        menu();
    }

    public static void closeSession() {
        MainView.start();
    }

}