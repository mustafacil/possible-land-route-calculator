package com.calculator.possiblelandroutecalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @DisplayName("Test if two countries are in same region return true if they are in same region")
    @Test
    void shouldReturnTrue_WhenGivenTwoCountriesAreInSameRegion(){
        //Given
        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorders(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");

        Country aus = new Country();
        aus.setCca3("AUS");
        aus.setBorders(new HashSet<>(Arrays.asList("GER", "HUN", "FRA", "BLG")));
        aus.setRegion("Europe");

        //When

        //Then
        assertTrue(ger.isInSameRegionWith(aus));

    }

    @DisplayName("Test if two countries are not in same region return false if they are not in same region")
    @Test
    void shouldReturnFalse_WhenGivenTwoCountriesAreInDifferentRegion(){

        //Given
        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorders(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");

        Country sko = new Country();
        sko.setCca3("SKO");
        sko.setBorders(new HashSet<>(Arrays.asList("NKO")));
        sko.setRegion("Asia");

        //When

        //Then
        assertFalse(ger.isInSameRegionWith(sko));

    }
}