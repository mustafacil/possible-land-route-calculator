package com.calculator.possiblelandroutecalculator.service;

import com.calculator.possiblelandroutecalculator.client.CountryClient;
import com.calculator.possiblelandroutecalculator.factory.CountryGraphFactory;
import com.calculator.possiblelandroutecalculator.factory.CountryMapFactory;
import com.calculator.possiblelandroutecalculator.model.Country;

import com.calculator.possiblelandroutecalculator.model.CountryGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Country graph service implementation class to find the route
 */
@Service
public class CountryGraphServiceImpl implements CountryGraphService{

    private final CountryMapFactory countryMapFactory;
    private final CountryGraphFactory countryGraphFactory;
    private final CountryClient countryClient;

    @Autowired
    public CountryGraphServiceImpl(CountryMapFactory countryMapFactory, CountryGraphFactory countryGraphFactory, CountryClient countryClient) {
        this.countryMapFactory = countryMapFactory;
        this.countryGraphFactory = countryGraphFactory;
        this.countryClient = countryClient;
    }

    /**
     * Function to get the route if possible between origin and destination countries
     * @param origin is the name of the origin {@link Country}
     * @param destination is the name of the destination {@link Country}
     * @return the list that contains the countries that create the route.
     */
    @Override
    public List<String> findRoute(String origin, String destination) {

        List<Country> countryList = countryClient.getCountryList();

        Country originCountry = countryMapFactory.getCountryMapByCca3(countryList).get(origin);
        String region = originCountry.getRegion();

        Map<String, List<Country>> countryListMapByRegion = countryMapFactory.getCountryListMapByRegion(countryList);

        CountryGraph countryGraph = countryGraphFactory.getCountryGraphMapByRegion(countryListMapByRegion).get(region);
        //Clear breadth first search queue and clear visited country stack to calculate a new route.
        countryGraph.refreshGraph();

        List<String> route = countryGraph.findRoute(origin, destination);

        return route;
    }
}
