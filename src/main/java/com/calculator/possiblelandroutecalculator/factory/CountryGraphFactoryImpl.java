package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;
import com.calculator.possiblelandroutecalculator.model.CountryGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Country graph factory implementation class to create a country graph
 */
@Service
public class CountryGraphFactoryImpl implements CountryGraphFactory {


    /**
     * Function to create {@link Country} graph for each region
     * and add them to a map. It caches the map.
     * @param countryListMapByRegion holds the list of countries
     * as the key and the region name as the value
     * @return a map contains {@link Country} graphs
     */
    @Cacheable("countryGraphByRegion")
    @Override
    public Map<String, CountryGraph> getCountryGraphMapByRegion(Map<String, List<Country>> countryListMapByRegion) {

        Map<String, CountryGraph> countryGraphByRegionMap = new HashMap<>();

        Set<String> regionSet = countryListMapByRegion.keySet();

        for (String region : regionSet) {
            //Create countryGraph with given country list for each region
            CountryGraph countryGraph = new CountryGraph(countryListMapByRegion.get(region));
            countryGraphByRegionMap.put(region, countryGraph);
        }
        return countryGraphByRegionMap;
    }


}
