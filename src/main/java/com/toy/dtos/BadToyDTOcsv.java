package com.toy.dtos;

import com.opencsv.bean.CsvBindByName;

public class BadToyDTOcsv {
    @CsvBindByName(column = "ID")
    private String id;

    @CsvBindByName(column = "Título")
    private String title;

    @CsvBindByName(column = "Tipo")
    private String type;

    @CsvBindByName(column = "Contenido")
    private String content;

    public BadToyDTOcsv(String id, String title, String type, String content) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.content = content;
    }
}
