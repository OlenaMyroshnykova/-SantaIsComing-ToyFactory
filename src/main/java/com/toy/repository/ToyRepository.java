package com.toy.repository;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import com.toy.db.BadToyDatabase;
import com.toy.db.GoodToyDatabase;
import com.toy.db.IDatabase;
import com.toy.dtos.BadToyDTO;
import com.toy.dtos.BadToyDTOcsv;
import com.toy.dtos.GoodToyDTO;
import com.toy.dtos.GoodToyDTOcsv;
import com.toy.models.BadToy;
import com.toy.models.GoodToy;
import com.toy.singletons.BadToyDatabaseSingleton;
import com.toy.singletons.GoodToyDatabaseSingleton;

@SuppressWarnings("rawtypes")
public class ToyRepository {

    private IDatabase db;
    private final GoodToyDatabase goodToyDatabase = GoodToyDatabaseSingleton.getInstance();
    private final BadToyDatabase badToyDatabase = BadToyDatabaseSingleton.getInstance();    

    public void setDB(String type) {
        // setter injection
        if (type == "good_toy")
            this.db = GoodToyDatabaseSingleton.getInstance();

        if (type == "bad_toy")
            this.db = BadToyDatabaseSingleton.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void saveGoodToy(GoodToy toy) {
        db.save(toy);
                
    }

    @SuppressWarnings("unchecked")
    public void saveBadToy(BadToy toy) {
        db.save(toy);
               
    }

    public List<GoodToy> getGoodToys() {
        List<GoodToy> goodToys = goodToyDatabase.getToys();

        return goodToys;
    }
    
    public List<BadToy> getBadToys() {
        List<BadToy> badToys = badToyDatabase.getToys();

        return badToys;
    }
    
    public List<Object> getAllToys() {
        List<Object> allToys = new ArrayList<>();

        List<GoodToy> goodToys = goodToyDatabase.getToys();
        allToys.addAll(goodToys);

        List<BadToy> badToys = badToyDatabase.getToys();
        allToys.addAll(badToys);

        return allToys;
    }

    public boolean deleteToyById(String id) {
        if (id.startsWith("B")) {
            return goodToyDatabase.getToys().removeIf(toy -> toy.getId().equals(id));
        }
        if (id.startsWith("M")) {
            return badToyDatabase.getToys().removeIf(toy -> toy.getId().equals(id));
        }

        System.out.println("No se pudo eliminar el juguete. Verifique el ID: " + id);
        return false;
    }

    public boolean saveAllToysToCSV() {
        String filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "com", "toy", "repository", "Toys.csv").toString();

        try (FileWriter writer = new FileWriter(filePath)) {
            StatefulBeanToCsv<GoodToyDTOcsv> goodToyCsvWriter = new StatefulBeanToCsvBuilder<GoodToyDTOcsv>(writer).build();

            List<GoodToy> goodToys = goodToyDatabase.getToys();
            for (GoodToy toy : goodToys) {
                GoodToyDTOcsv dto = new GoodToyDTOcsv(toy.getId(), toy.getTitle(), "Good", toy.getCategory());
                goodToyCsvWriter.write(dto);
            }

            StatefulBeanToCsv<BadToyDTOcsv> badToyCsvWriter = new StatefulBeanToCsvBuilder<BadToyDTOcsv>(writer).withApplyQuotesToAll(false).build();
            List<BadToy> badToys = badToyDatabase.getToys();
            for (BadToy toy : badToys) {
                BadToyDTOcsv dto = new BadToyDTOcsv(toy.getId(), toy.getTitle(), "Bad", toy.getContent());
                badToyCsvWriter.write(dto);
            }

            System.out.println("Archivo CSV guardado en: " + filePath);
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar los juguetes en el archivo CSV: " + e.getMessage());
            return false;
        }    }

}
