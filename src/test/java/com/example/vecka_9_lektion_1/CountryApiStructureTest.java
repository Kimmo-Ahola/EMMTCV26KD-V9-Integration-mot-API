package com.example.vecka_9_lektion_1;


import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Vi testar att API:ts svarsstruktur innehåller de fält vi förväntar oss
//name, region, subregion, languages, population och borders.
// Alltså inte värden, utan att nycklarna faktiskt finns med i svaret.
// Om externa API:t skulle ta bort eller byta namn på ett fält,
// fångar detta test det innan det kraschar någon annanstans i koden.


public class CountryApiStructureTest {
    @Test
    public void countryByNameShouldContainExpectedFields(){
        // Skriv om så denna är i CountryService
        WebClient client = WebClient.create(ApiConstants.BASE_URL_V3);

        var response = client.get()
                .uri("/name/sweden")
                .retrieve()
                .bodyToMono(Map[].class)
                .block();

        assertNotNull(response);
        assertTrue(response.length > 0);

        var country = response[0];

        assertTrue(country.containsKey("name"));
        assertTrue(country.containsKey("region"));
        assertTrue(country.containsKey("subregion"));
        assertTrue(country.containsKey("languages"));
        assertTrue(country.containsKey("population"));
        assertTrue(country.containsKey("borders"));
    }
}
