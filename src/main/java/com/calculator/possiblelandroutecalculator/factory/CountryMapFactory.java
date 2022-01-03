package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;

import java.util.List;
import java.util.Map;

/**
 * Country map factory interface
 */
public interface CountryMapFactory {

    Map<String, Country> getCountryMapByCca3(List<Country> countryList);
    Map<String, List<Country>> getCountryListMapByRegion(List<Country> countryList);
}
