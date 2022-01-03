package com.calculator.possiblelandroutecalculator.service;

/**
 * Country service interface
 */
public interface CountryService {

    boolean countriesAreInSameRegion(String origin, String destination);

}
