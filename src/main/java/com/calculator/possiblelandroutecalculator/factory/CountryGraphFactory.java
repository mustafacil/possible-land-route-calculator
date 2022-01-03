package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;
import com.calculator.possiblelandroutecalculator.model.CountryGraph;

import java.util.List;
import java.util.Map;

/**
 * Country graph factory interface
 */
public interface CountryGraphFactory {

    Map<String, CountryGraph> getCountryGraphMapByRegion(Map<String, List<Country>> countryListMapByRegion);

}
