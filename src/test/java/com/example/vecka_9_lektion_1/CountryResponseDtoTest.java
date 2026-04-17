package com.example.vecka_9_lektion_1;

import com.example.vecka_9_lektion_1.dto.CountryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryResponseDtoTest {
    @Test
    void countryResponse_deserializesLatviaCorrectly() {
        WebClient client = WebClient.create(ApiConstants.BASE_URL_V3);

        CountryResponse[] response = client.get()
                .uri("/name/latvia")
                .retrieve()
                .bodyToMono(CountryResponse[].class)
                .block();

        assertNotNull(response);
        assertTrue(response.length > 0);

        CountryResponse latvia = response[0];

        assertEquals("Latvia", latvia.name().common());
        assertEquals("Republic of Latvia", latvia.name().official());
        assertEquals("Europe", latvia.region());
        assertEquals("Northern Europe", latvia.subregion());
        assertEquals(1829000, latvia.population()); // kan vara dåligt eftersom den ändras
        assertEquals(Map.of("lav", "Latvian"), latvia.languages());
        assertEquals(List.of("BLR", "EST", "LTU", "RUS"), latvia.borders());
    }
}
