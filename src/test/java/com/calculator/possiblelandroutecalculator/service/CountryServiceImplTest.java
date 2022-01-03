package com.calculator.possiblelandroutecalculator.service;

import com.calculator.possiblelandroutecalculator.client.CountryClient;
import com.calculator.possiblelandroutecalculator.factory.CountryMapFactory;
import com.calculator.possiblelandroutecalculator.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceImplTest {

    private CountryMapFactory countryMapFactory;
    private CountryClient countryClient;

    private CountryService countryService;

    @BeforeEach
    void setUp(){

        countryClient = Mockito.mock(CountryClient.class);
        countryMapFactory = Mockito.mock(CountryMapFactory.class);
        Mockito.when(countryMapFactory.getCountryMapByCca3(Mockito.anyList())).thenReturn(getUnderTestCountryMapByCca3());

        countryService = new CountryServiceImpl(countryMapFactory, countryClient);
    }

    @Test
    void shouldReturnTrue_WhenGivenOriginAndDestinationAreInSameRegion(){
        //Given

        //When

        //Then
        assertTrue(countryService.countriesAreInSameRegion("GER", "AUS"));

    }

    @Test
    void shouldReturnFalse_WhenGivenOriginAndDestinationAreNotInSameRegion(){
        //Given

        //When

        //Then
        assertFalse(countryService.countriesAreInSameRegion("GER", "LAO"));

    }

    @Test
    void shouldReturnFalse_WhenGivenOriginOrDestinationAreNotInCountryList(){
        //Given

        //When

        //Then
        assertAll(
                () -> assertFalse(countryService.countriesAreInSameRegion("GER", "XXX")),
                () -> assertFalse(countryService.countriesAreInSameRegion("XXX", "XXX"))
        );



    }


    public Map<String, Country> getUnderTestCountryMapByCca3() {

        Map<String, Country> underTestCountryMapByCca3 = getCountryList().stream().collect(Collectors.toMap(Country::getCca3, country -> country));

        return underTestCountryMapByCca3;

    }

    public List<Country> getCountryList(){

        List<Country> countryList = new LinkedList<>();

        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorders(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");
        countryList.add(ger);


        Country aus = new Country();
        aus.setCca3("AUS");
        aus.setBorders(new HashSet<>(Arrays.asList("GER", "HUN", "FRA", "BLG")));
        aus.setRegion("Europe");
        countryList.add(aus);

        Country nth = new Country();
        nth.setCca3("NTH");
        nth.setBorders(new HashSet<>(Arrays.asList("GER", "PLN", "LXM")));
        nth.setRegion("Europe");
        countryList.add(nth);


        Country cam = new Country();
        cam.setCca3("CAM");
        cam.setBorders(new HashSet<>(Arrays.asList("VIE", "LAO")));
        cam.setRegion("Asia");
        countryList.add(cam);


        Country lao = new Country();
        lao.setCca3("LAO");
        lao.setBorders(new HashSet<>(Arrays.asList("CHI", "VIE", "CAM")));
        lao.setRegion("Asia");
        countryList.add(lao);

        return countryList;
    }
}