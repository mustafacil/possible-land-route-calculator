package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CountryMapFactoryImplTest {

    private CountryMapFactory countryMapFactory;

    @BeforeEach
    void setUp() {
        countryMapFactory = new CountryMapFactoryImpl();

    }

    @Test
    void shouldCreateCountryMapByCca3_WithGivenCountryList() {

        //Given
        List<Country> underTestCountryList = getUnderTestCountryList();

        //When
        Map<String, Country> actualCountryMapByCca3 = countryMapFactory.getCountryMapByCca3(underTestCountryList);

        //Then
        assertEquals(17, actualCountryMapByCca3.size());

    }

    @Test
    void shouldCreateCountryListMapByRegion_WithGivenCountryList() {

        //Given
        List<Country> underTestCountryList = getUnderTestCountryList();

        //When
        Map<String, List<Country>> actualCountryListMapByRegion = countryMapFactory.getCountryListMapByRegion(underTestCountryList);

        //Then
        assertAll(
                () -> assertEquals(2, actualCountryListMapByRegion.size()),
                () -> assertEquals(10, actualCountryListMapByRegion.get("Europe").size()),
                () -> assertEquals(7, actualCountryListMapByRegion.get("Asia").size())
        );


    }

    public List<Country> getUnderTestCountryList() {

        List<Country> underTestCountryList = new LinkedList<>();

        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorders(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");
        underTestCountryList.add(ger);


        Country aus = new Country();
        aus.setCca3("AUS");
        aus.setBorders(new HashSet<>(Arrays.asList("GER", "HUN", "FRA", "BLG")));
        aus.setRegion("Europe");
        underTestCountryList.add(aus);

        Country nth = new Country();
        nth.setCca3("NTH");
        nth.setBorders(new HashSet<>(Arrays.asList("GER", "PLN", "LXM")));
        nth.setRegion("Europe");
        underTestCountryList.add(nth);

        Country hun = new Country();
        hun.setCca3("HUN");
        hun.setBorders(new HashSet<>(Arrays.asList("AUS", "ITL")));
        hun.setRegion("Europe");
        underTestCountryList.add(hun);

        Country itl = new Country();
        itl.setCca3("ITL");
        itl.setBorders(new HashSet<>(Arrays.asList("HUN")));
        itl.setRegion("Europe");
        underTestCountryList.add(itl);

        Country fra = new Country();
        fra.setCca3("FRA");
        fra.setBorders(new HashSet<>(Arrays.asList("AUS", "BLG")));
        fra.setRegion("Europe");
        underTestCountryList.add(fra);

        Country blg = new Country();
        blg.setCca3("BLG");
        blg.setBorders(new HashSet<>(Arrays.asList("AUS", "FRA", "SWZ")));
        blg.setRegion("Europe");
        underTestCountryList.add(blg);

        Country swz = new Country();
        swz.setCca3("SWZ");
        swz.setBorders(new HashSet<>(Arrays.asList("BLG")));
        swz.setRegion("Europe");
        underTestCountryList.add(swz);

        Country pln = new Country();
        pln.setCca3("PLN");
        pln.setBorders(new HashSet<>(Arrays.asList("NTH")));
        pln.setRegion("Europe");
        underTestCountryList.add(pln);

        Country lxm = new Country();
        lxm.setCca3("LXM");
        lxm.setBorders(new HashSet<>(Arrays.asList("NTH", "SPA")));
        lxm.setRegion("Europe");
        underTestCountryList.add(lxm);

        Country chi = new Country();
        chi.setCca3("CHI");
        chi.setBorders(new HashSet<>(Arrays.asList("MON", "NKO", "VIE", "LAO")));
        chi.setRegion("Asia");
        underTestCountryList.add(chi);

        Country mon = new Country();
        mon.setCca3("MON");
        mon.setBorders(new HashSet<>(Arrays.asList("CHI")));
        mon.setRegion("Asia");
        underTestCountryList.add(mon);

        Country nko = new Country();
        nko.setCca3("NKO");
        nko.setBorders(new HashSet<>(Arrays.asList("SKO")));
        nko.setRegion("Asia");
        underTestCountryList.add(nko);

        Country sko = new Country();
        sko.setCca3("SKO");
        sko.setBorders(new HashSet<>(Arrays.asList("NKO")));
        sko.setRegion("Asia");
        underTestCountryList.add(sko);

        Country vie = new Country();
        vie.setCca3("VIE");
        vie.setBorders(new HashSet<>(Arrays.asList("CHI", "LAO", "CAM")));
        vie.setRegion("Asia");
        underTestCountryList.add(vie);

        Country cam = new Country();
        cam.setCca3("CAM");
        cam.setBorders(new HashSet<>(Arrays.asList("VIE", "LAO")));
        cam.setRegion("Asia");
        underTestCountryList.add(cam);

        Country lao = new Country();
        lao.setCca3("LAO");
        lao.setBorders(new HashSet<>(Arrays.asList("CHI", "VIE", "CAM")));
        lao.setRegion("Asia");
        underTestCountryList.add(lao);


        return underTestCountryList;

    }
}