package com.example.vecka_9_lektion_1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

//A DTO (Data Transfer Object) acts as a buffer between the external API and your application.
//The REST Countries API returns massive JSON objects with dozens of fields
//This also means if the external API adds or renames fields tomorrow, your app won't break.
//The flow is then clean and intentional:

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountryResponse(
        Name name,
        String region,
        String subregion,
        Long population,
        Map<String, String> languages,
        List<String> borders
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Name (
        String common, // Skrev Common med stort C
        String official
    ) {}
}
