package com.example.vecka_9_lektion_1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

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
