package com.example.vecka_9_lektion_1.service;

import com.example.vecka_9_lektion_1.client.CountryApiClient;
import com.example.vecka_9_lektion_1.dto.CountryResponse;
import com.example.vecka_9_lektion_1.model.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final CountryApiClient webClient;
    public CountryService(CountryApiClient webApiClient) {
        this.webClient = webApiClient;
    }

    public List<Country> getAllCountryNames() {
        CountryResponse[] response = webClient
                .fetchAllCountryNames();

        if (response == null) {
            throw new AssertionError("Response is null");
        }

        return Arrays.stream(response)
                .map(r -> new Country(r.name().common()))
                .collect(Collectors.toList());
    }

    public Country getCountryByName(String requestedName) {
        CountryResponse[] response = webClient
                .fetchCountryByName(requestedName);

        if (response == null) throw new AssertionError("Response is null");

        CountryResponse data = response[0];

        return new Country(
                data.name().common(),
                data.name().official(),
                data.region(),
                data.subregion(),
                data.languages(),
                data.borders(),
                data.population()
        );
    }
}
