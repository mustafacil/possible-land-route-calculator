package com.calculator.possiblelandroutecalculator.service;

import com.calculator.possiblelandroutecalculator.client.CountryClient;
import com.calculator.possiblelandroutecalculator.factory.CountryMapFactory;
import com.calculator.possiblelandroutecalculator.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Country service interface implementation class
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapFactory countryMapFactory;
    private final CountryClient countryClient;

    public CountryServiceImpl(CountryMapFactory countryMapFactory, CountryClient countryClient) {
        this.countryMapFactory = countryMapFactory;
        this.countryClient = countryClient;
    }

    /**
     * Function to check origin and destination countries are in the same region
     *
     * @param origin      is the name of the origin {@link Country}
     * @param destination is the name of the destination {@link Country}
     * @return if two countries are in the same region.
     */
    @Override
    public boolean countriesAreInSameRegion(String origin, String destination) {

        List<Country> countryList = countryClient.getCountryList();
        Map<String, Country> countryByCca3Map = countryMapFactory.getCountryMapByCca3(countryList);
        Country originCountry = countryByCca3Map.get(origin);
        Country destinationCountry = countryByCca3Map.get(destination);

        if (originCountry == null || destinationCountry == null) {
            return false;
        }

        return originCountry.isInSameRegionWith(destinationCountry);
    }
}
