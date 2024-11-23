package com.toy.views;

import java.util.List;

import com.toy.controllers.ToyController;
import com.toy.dtos.BadToyDTO;
import com.toy.dtos.GoodToyDTO;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.repository.ToyRepository;
import com.toy.singletons.ToyRepositorySingleton;

public class SantaView extends View {

    //private static final ToyController controller = new ToyController();
    private static final ToyRepository repository = ToyRepositorySingleton.getInstance();

    public static void menu() {
        System.out.println("-----------------------------------------");
        System.out.println("Gestor de juguetes (Tipo de sesión: Santa)");
        System.out.println("1. Ver lista de juguetes niños buenos");
        System.out.println("2. Ver lista de juguetes niños malos");
        System.out.println("3. Guargar lista de todos los juguetes (.csv)");
        System.out.println("4. Cerrar sesión");
        System.out.println("Seleccione una opción:");

        int option = scanner.nextInt();

        if (option == 1) displayGoodToys();
        if (option == 2) displayBadToys();
        if (option == 3) saveToysToCSV();
        if (option == 4) closeSession();
    }

    public static void saveToysToCSV() {
        boolean success = repository.saveAllToysToCSV();
    
        if (success) {
            System.out.println("Juguetes guardados con éxito en el archivo Toys.csv dentro de la carpeta del repositorio.");
        } else {
            System.out.println("Error al guardar los juguetes en el archivo CSV.");
        }
    }

    public static void displayGoodToys() {
        System.out.println("-----------------------------------------");
        
        List<GoodToy> goodToys = repository.getGoodToys();

        if (goodToys.isEmpty()) {
            System.out.println("No hay juguetes buenos en el inventario.");
        } else {
            System.out.println("Lista de todos los juguetes buenos:");
            for (Object toy : goodToys) {
                GoodToy goodToy = (GoodToy) toy;
                System.out.println("Buen juguete - ID: " + goodToy.getId() + ", Título: " + goodToy.getTitle());
            }
        }
        menu();
    }

    public static void displayBadToys() {
        System.out.println("-----------------------------------------");
        List<BadToy> badToys = repository.getBadToys();

        if (badToys.isEmpty()) {
            System.out.println("No hay juguetes malos en el inventario.");
        } else {
            System.out.println("Lista de todos los juguetes malos:");
            for (Object toy : badToys) {
                 if (toy instanceof BadToy) {
                    BadToy badToy = (BadToy) toy;
                    System.out.println("Mal juguete - ID: " + badToy.getId() + ", Título: " + badToy.getTitle() + ", Contenido: " + badToy.getContent());
                }
            }
        }
        menu();
    }
    
    public static void closeSession() {
        MainView.start();
    }

}
