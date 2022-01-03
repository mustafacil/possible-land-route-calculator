package com.calculator.possiblelandroutecalculator.client;

import com.calculator.possiblelandroutecalculator.model.Country;

import java.util.List;

/**
 * Country client interface to get all countries from an external source
 */
public interface CountryClient {

    List<Country> getCountryList();

}
