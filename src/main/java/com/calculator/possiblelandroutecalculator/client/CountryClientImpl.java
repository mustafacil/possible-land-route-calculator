package com.calculator.possiblelandroutecalculator.client;

import com.calculator.possiblelandroutecalculator.model.Country;
import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Country client implementation class to get all countries from github
 */
@Service
public class CountryClientImpl implements CountryClient{

    /**
     * Function to retrieve all countries as {@link Country} list from github
     * @return list of all countries
     */
    @Cacheable("countryList")
    @Override
    public List<Country> getCountryList() {

        RestTemplate restTemplate = new RestTemplateBuilder().build();

        String url = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";

        String response = restTemplate.getForObject(url, String.class);

        Gson converter = new Gson();

        Country[] countryArr = converter.fromJson(response, Country[].class);

        return Arrays.asList(countryArr);
    }
}
