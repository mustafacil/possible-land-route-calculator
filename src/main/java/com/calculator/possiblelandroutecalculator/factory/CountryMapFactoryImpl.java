package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.client.CountryClient;
import com.calculator.possiblelandroutecalculator.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryMapFactoryImpl implements CountryMapFactory {

    private final CountryClient countryClient;

    @Autowired
    public CountryMapFactoryImpl(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @Override
    public Map<String, String> getCountryMapByRegion() {

        List<Country> countryList = countryClient.getCountryList();

        Map<String, String> countryMapByRegion = countryList.stream().collect(
                Collectors.toMap(Country::getCca3, Country::getRegion)
        );

        return countryMapByRegion;

    }

    @Override
    public Map<String, List<Country>> getCountryListMapByRegion() {

        List<Country> countryList = countryClient.getCountryList();

        Map<String, List<Country>> countryListByRegionMap = new HashMap<>();

        countryList.forEach(country -> {

            String regionOfCountry = country.getRegion();

            if (!countryListByRegionMap.containsKey(regionOfCountry)) {

                List<Country> countryListByRegion = new LinkedList<>();
                countryListByRegion.add(country);
                countryListByRegionMap.put(country.getRegion(), countryListByRegion);

            } else {
                countryListByRegionMap.get(regionOfCountry).add(country);

            }

        });

        return countryListByRegionMap;

    }
}
