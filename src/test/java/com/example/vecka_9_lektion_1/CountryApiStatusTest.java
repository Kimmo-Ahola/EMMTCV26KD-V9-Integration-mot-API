package com.example.vecka_9_lektion_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryApiStatusTest {
    @Value("{SECRET_KEY}")
    private String secretKey;
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
