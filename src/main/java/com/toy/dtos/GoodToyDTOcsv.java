package com.toy.dtos;

import com.opencsv.bean.CsvBindByName;

public class GoodToyDTOcsv {
    @CsvBindByName(column = "ID")
    private String id;

    @CsvBindByName(column = "Título")
    private String title;

    @CsvBindByName(column = "Tipo")
    private String type;

    @CsvBindByName(column = "Categoría")
    private String category;

    public GoodToyDTOcsv(String id, String title, String type, String category) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.category = category;
    }
}