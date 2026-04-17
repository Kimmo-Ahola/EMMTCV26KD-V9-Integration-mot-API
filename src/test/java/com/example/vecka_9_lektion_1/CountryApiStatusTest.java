package com.example.vecka_9_lektion_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryApiStatusTest {
    // Exempel på hur man skulle kunna ladda in en secret i ett lokalt test
    // används inte i detta test
    @Value("${SECRET_KEY}")
    private String secretKey;


    // Vi vill endast se att api:t är igång och vill då se status 200. Inget mer.
    // Ett sk "smoke test" som körs innan resten av sviten för att säkerställa att vi inte slösar tid på tester mot
    // ett api som inte är igång.
    @Test
    public void allCountriesShouldReturn200() {
        WebClient client = WebClient.create(ApiConstants.BASE_URL_V3);

        // Övning, ändra på denna så att den använder service istället
        var response = client
                .get()
                .uri("/all?fields=name")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null){
            throw new AssertionError("Response is null");
        }

        assertEquals(200, response.getStatusCode().value());
    }
}
