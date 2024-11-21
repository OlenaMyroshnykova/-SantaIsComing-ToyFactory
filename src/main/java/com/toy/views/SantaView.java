package com.toy.views;

import com.toy.controllers.ToyController;
import com.toy.dtos.BadToyDTO;
import com.toy.dtos.GoodToyDTO;

public class SantaView extends View {

    private static final ToyController controller = new ToyController();

    public static void menu() {
        System.out.println("-----------------------------------------");
        System.out.println("Gestor de juguetes (Tipo de sesión: Santa)");
        System.out.println("1. Ver lista de juguetes niños buenos");
        System.out.println("2. Ver lista de juguetes niños malos");
        System.out.println("3. Guargar lista de todos los juguetes (.csv)");
        System.out.println("4. Cerrar sesión");
        System.out.println("Seleccione una opción:");

        int option = scanner.nextInt();

        //if (option == 1) selectChild();
        if (option == 4) closeSession();
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
