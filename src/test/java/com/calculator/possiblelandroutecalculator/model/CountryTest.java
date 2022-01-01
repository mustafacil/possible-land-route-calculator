package com.calculator.possiblelandroutecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void shouldReturnTrue_WhenGivenTwoCountriesAreInSameRegion(){

        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorderSet(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");

        Country aus = new Country();
        aus.setCca3("AUS");
        aus.setBorderSet(new HashSet<>(Arrays.asList("GER", "HUN", "FRA", "BLG")));
        aus.setRegion("Europe");

        assertEquals(true, ger.isInSameRegion(aus));

    }


    @Test
    void shouldReturnFalse_WhenGivenTwoCountriesAreInDifferentRegion(){

        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorderSet(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");

        Country sko = new Country();
        sko.setCca3("SKO");
        sko.setBorderSet(new HashSet<>(Arrays.asList("NKO")));
        sko.setRegion("Asia");

        assertEquals(false, ger.isInSameRegion(sko));

    }
}