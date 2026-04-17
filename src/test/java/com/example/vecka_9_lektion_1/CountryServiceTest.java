package com.example.vecka_9_lektion_1;

import com.example.vecka_9_lektion_1.client.CountryApiClient;
import com.example.vecka_9_lektion_1.model.Country;
import com.example.vecka_9_lektion_1.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CountryServiceTest {
    private CountryService countryService;
    @BeforeEach
    public void setup() {
        CountryApiClient countryApiClient = new CountryApiClient(WebClient.builder());
        countryService = new CountryService(countryApiClient);
    }

    @Test
    public void getAllCountryNames_returnsCorrectNumberOfCountries() {
        List<Country> countryList = countryService.getAllCountryNames();

        assertNotNull(countryList);
        assertEquals(250, countryList.size());
    }

    @Test
    public void getCountryByName_latvia_containsCorrectMappedData() {
        Country latvia = countryService.getCountryByName("latvia");
        assertNotNull(latvia);

        assertEquals("Latvia", latvia.getCommonName());
        assertEquals("Republic of Latvia", latvia.getOfficialName());
        assertEquals("Europe", latvia.getRegion());
        assertEquals("Northern Europe", latvia.getSubregion());

        assertEquals(1829000, latvia.getPopulation());

        assertEquals(
                Map.of("lav", "Latvian"),
                latvia.getLanguages()
        );

        assertEquals(
                List.of("BLR", "EST", "LTU", "RUS"),
                latvia.getBorders()
        );
    }
}
