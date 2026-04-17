package com.example.vecka_9_lektion_1.client;

import com.example.vecka_9_lektion_1.dto.CountryResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CountryApiClient {
    private static final String BASE_URL = "https://restcountries.com/v3.1";

    private final WebClient webClient;

    public CountryApiClient(WebClient.Builder builder){
        this.webClient = builder.baseUrl(BASE_URL).build();
    }

    public CountryResponse[] fetchAllCountryNames(){
        return webClient
                .get()
                .uri("/all?fields=name")
                .retrieve()
                .bodyToMono(CountryResponse[].class)
                .block();
    }

    public CountryResponse[] fetchCountryByName(String name){
        return webClient
                .get()
                .uri("/name/{name}", name)
                .retrieve()
                .bodyToMono(CountryResponse[].class)
                .block();
    }
}
