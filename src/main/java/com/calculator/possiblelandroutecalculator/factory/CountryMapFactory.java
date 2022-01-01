package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;

import java.util.List;
import java.util.Map;

public interface CountryMapFactory {

    Map<String, String> getCountryMapByRegion();
    Map<String, List<Country>> getCountryListMapByRegion();
}
