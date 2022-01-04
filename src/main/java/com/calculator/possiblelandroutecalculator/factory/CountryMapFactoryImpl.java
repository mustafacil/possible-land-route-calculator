package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Country map factory implementation class to create maps related countries
 */
@Service
public class CountryMapFactoryImpl implements CountryMapFactory {

    /**
     * Function to create a map contains {@link Country} name as the key
     * and {@link Country} instance as the value. The map is being cached.
     * @param countryList holds the {@link Country} instances
     * @return the {@link Country} by name map
     */
    @Cacheable("countryMapByCca3")
    @Override
    public Map<String, Country> getCountryMapByCca3(List<Country> countryList) {

        Map<String, Country> countryMapByRegion = countryList.stream().collect(
                Collectors.toMap(Country::getCca3, country -> country)
        );

        return countryMapByRegion;

    }

    /**+
     * Function to create a map contains region name as the key
     * and {@link Country} list as the value. The map is being cached.
     * @param countryList holds the {@link Country} instances
     * @return the {@link Country} List by region map
     */
    @Cacheable("countryListMapByRegion")
    @Override
    public Map<String, List<Country>> getCountryListMapByRegion(List<Country> countryList) {

        Map<String, List<Country>> countryListByRegionMap = new HashMap<>();

        countryList.forEach(country -> {

            String regionOfCountry = country.getRegion();
            /*
            If the map does not contain a region as a key, then create,
            otherwise add the country to list.
             */

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

