package com.calculator.possiblelandroutecalculator.service;

import com.calculator.possiblelandroutecalculator.client.CountryClient;
import com.calculator.possiblelandroutecalculator.factory.CountryGraphFactory;
import com.calculator.possiblelandroutecalculator.factory.CountryGraphFactoryImpl;
import com.calculator.possiblelandroutecalculator.factory.CountryMapFactory;
import com.calculator.possiblelandroutecalculator.model.Country;
import com.calculator.possiblelandroutecalculator.model.CountryGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountryGraphServiceImplTest {

    private CountryMapFactory countryMapFactory;
    private CountryGraphFactory countryGraphFactory;
    private CountryClient countryClient;

    private CountryGraphService countryGraphService;

    @BeforeEach
    void setUp() {

        countryMapFactory = Mockito.mock(CountryMapFactory.class);
        Mockito.when(countryMapFactory.getCountryMapByCca3(Mockito.anyList())).thenReturn(getUnderTestCountryMapByCca3());

        countryClient = Mockito.mock(CountryClient.class);

        countryGraphFactory = Mockito.mock(CountryGraphFactory.class);
        Mockito.when(countryGraphFactory.getCountryGraphMapByRegion(Mockito.anyMap())).thenReturn(getUnderTestCountryGraphMapByRegion());

        countryGraphService = new CountryGraphServiceImpl(countryMapFactory, countryGraphFactory, countryClient);


    }

    @Test
    void shouldFindARoute_WithGivenOriginAndDestinationInSameRegion() {

        //Expected
        List<String> expectedRoute = Arrays.asList("GER", "AUS", "HUN", "ITL");

        //Given

        //When
        List<String> actualRoute = countryGraphService.findRoute("GER", "ITL");

        //Then
        assertEquals(expectedRoute,actualRoute);


    }


    public Map<String, CountryGraph> getUnderTestCountryGraphMapByRegion() {

        List<Country> countryList = getCountryList();

        List<Country> europeRegionCountryList = countryList.stream().filter(country -> country.getRegion().equals("Europe")).collect(Collectors.toList());
        List<Country> asiaRegionCountryList = countryList.stream().filter(country -> country.getRegion().equals("Asia")).collect(Collectors.toList());

        CountryGraph europeRegionGraph = new CountryGraph(europeRegionCountryList);
        CountryGraph asiaRegionGraph = new CountryGraph(asiaRegionCountryList);

        Map<String, CountryGraph> underTestCountryGraphMapByRegion = new HashMap<>();
        underTestCountryGraphMapByRegion.put("Europe", europeRegionGraph);
        underTestCountryGraphMapByRegion.put("Asia", asiaRegionGraph);

        return underTestCountryGraphMapByRegion;
    }

    public Map<String, List<Country>> getUnderTestCountryListMapByRegion() {

        List<Country> countryList = getCountryList();

        List<Country> europeRegionCountryList = countryList.stream().filter(country -> country.getRegion().equals("Europe")).collect(Collectors.toList());
        List<Country> asiaRegionCountryList = countryList.stream().filter(country -> country.getRegion().equals("Asia")).collect(Collectors.toList());

        Map<String, List<Country>> underTestCountryListMapByRegion = new HashMap<>();
        underTestCountryListMapByRegion.put("Europe", europeRegionCountryList);
        underTestCountryListMapByRegion.put("Asia", asiaRegionCountryList);

        return underTestCountryListMapByRegion;

    }

    public Map<String, Country> getUnderTestCountryMapByCca3() {

        List<Country> countryList = getCountryList();

        Map<String, Country> underTestCountryMapByCca3 = countryList.stream().collect(Collectors.toMap(Country::getCca3, country -> country));

        return underTestCountryMapByCca3;
    }

    public List<Country> getCountryList() {

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

        Country hun = new Country();
        hun.setCca3("HUN");
        hun.setBorders(new HashSet<>(Arrays.asList("AUS", "ITL")));
        hun.setRegion("Europe");
        countryList.add(hun);

        Country itl = new Country();
        itl.setCca3("ITL");
        itl.setBorders(new HashSet<>(Arrays.asList("HUN")));
        itl.setRegion("Europe");
        countryList.add(itl);

        Country fra = new Country();
        fra.setCca3("FRA");
        fra.setBorders(new HashSet<>(Arrays.asList("AUS", "BLG")));
        fra.setRegion("Europe");
        countryList.add(fra);

        Country blg = new Country();
        blg.setCca3("BLG");
        blg.setBorders(new HashSet<>(Arrays.asList("AUS", "FRA", "SWZ")));
        blg.setRegion("Europe");
        countryList.add(blg);

        Country swz = new Country();
        swz.setCca3("SWZ");
        swz.setBorders(new HashSet<>(Arrays.asList("BLG")));
        swz.setRegion("Europe");
        countryList.add(swz);

        Country pln = new Country();
        pln.setCca3("PLN");
        pln.setBorders(new HashSet<>(Arrays.asList("NTH")));
        pln.setRegion("Europe");
        countryList.add(pln);

        Country lxm = new Country();
        lxm.setCca3("LXM");
        lxm.setBorders(new HashSet<>(Arrays.asList("NTH", "SPA")));
        lxm.setRegion("Europe");
        countryList.add(lxm);

        Country chi = new Country();
        chi.setCca3("CHI");
        chi.setBorders(new HashSet<>(Arrays.asList("MON", "NKO", "VIE", "LAO")));
        chi.setRegion("Asia");
        countryList.add(chi);

        Country mon = new Country();
        mon.setCca3("MON");
        mon.setBorders(new HashSet<>(Arrays.asList("CHI")));
        mon.setRegion("Asia");
        countryList.add(mon);

        Country nko = new Country();
        nko.setCca3("NKO");
        nko.setBorders(new HashSet<>(Arrays.asList("SKO")));
        nko.setRegion("Asia");
        countryList.add(nko);

        Country sko = new Country();
        sko.setCca3("SKO");
        sko.setBorders(new HashSet<>(Arrays.asList("NKO")));
        sko.setRegion("Asia");
        countryList.add(sko);

        Country vie = new Country();
        vie.setCca3("VIE");
        vie.setBorders(new HashSet<>(Arrays.asList("CHI", "LAO", "CAM")));
        vie.setRegion("Asia");
        countryList.add(vie);

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