package com.example.vecka_9_lektion_1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor // skapar tom konstruktor
@AllArgsConstructor // skapar konstruktor med alla attribut
public class Country {
    private String commonName;
    private String officialName;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private List<String> borders;
    private long population;

    public Country(String commonName) {
        this.commonName = commonName;
    }
}
