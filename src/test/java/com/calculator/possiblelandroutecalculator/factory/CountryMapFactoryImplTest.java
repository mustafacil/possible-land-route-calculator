package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.client.CountryClient;
import com.calculator.possiblelandroutecalculator.client.CountryClientImpl;
import com.calculator.possiblelandroutecalculator.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CountryMapFactoryImplTest {

    private CountryClient countryClient;
    private CountryMapFactory countryMapFactory;

    @BeforeEach
    void setUp() {

        countryClient = Mockito.mock(CountryClientImpl.class);
        countryMapFactory = new CountryMapFactoryImpl(countryClient);

        Mockito.when(countryClient.getCountryList()).thenReturn(getUnderTestCountryList());

    }

    @Test
    void shouldCreateCountryMapByRegion_WithGivenCountryList() {


        Map<String, String> actualCountryMapByRegionMap = countryMapFactory.getCountryMapByRegion();
        assertEquals(17, actualCountryMapByRegionMap.size());

    }

    @Test
    void shouldCreateCountryListMapByRegion_WithGivenCountryList() {

        Map<String, List<Country>> actualCountryListMapByRegion = countryMapFactory.getCountryListMapByRegion();

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
        ger.setBorderSet(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");
        underTestCountryList.add(ger);


        Country aus = new Country();
        aus.setCca3("AUS");
        aus.setBorderSet(new HashSet<>(Arrays.asList("GER", "HUN", "FRA", "BLG")));
        aus.setRegion("Europe");
        underTestCountryList.add(aus);

        Country nth = new Country();
        nth.setCca3("NTH");
        nth.setBorderSet(new HashSet<>(Arrays.asList("GER", "PLN", "LXM")));
        nth.setRegion("Europe");
        underTestCountryList.add(nth);

        Country hun = new Country();
        hun.setCca3("HUN");
        hun.setBorderSet(new HashSet<>(Arrays.asList("AUS", "ITL")));
        hun.setRegion("Europe");
        underTestCountryList.add(hun);

        Country itl = new Country();
        itl.setCca3("ITL");
        itl.setBorderSet(new HashSet<>(Arrays.asList("HUN")));
        itl.setRegion("Europe");
        underTestCountryList.add(itl);

        Country fra = new Country();
        fra.setCca3("FRA");
        fra.setBorderSet(new HashSet<>(Arrays.asList("AUS", "BLG")));
        fra.setRegion("Europe");
        underTestCountryList.add(fra);

        Country blg = new Country();
        blg.setCca3("BLG");
        blg.setBorderSet(new HashSet<>(Arrays.asList("AUS", "FRA", "SWZ")));
        blg.setRegion("Europe");
        underTestCountryList.add(blg);

        Country swz = new Country();
        swz.setCca3("SWZ");
        swz.setBorderSet(new HashSet<>(Arrays.asList("BLG")));
        swz.setRegion("Europe");
        underTestCountryList.add(swz);

        Country pln = new Country();
        pln.setCca3("PLN");
        pln.setBorderSet(new HashSet<>(Arrays.asList("NTH")));
        pln.setRegion("Europe");
        underTestCountryList.add(pln);

        Country lxm = new Country();
        lxm.setCca3("LXM");
        lxm.setBorderSet(new HashSet<>(Arrays.asList("NTH")));
        lxm.setRegion("Europe");
        underTestCountryList.add(lxm);

        Country chi = new Country();
        chi.setCca3("CHI");
        chi.setBorderSet(new HashSet<>(Arrays.asList("MON", "NKO", "VIE", "LAO")));
        chi.setRegion("Asia");
        underTestCountryList.add(chi);

        Country mon = new Country();
        mon.setCca3("MON");
        mon.setBorderSet(new HashSet<>(Arrays.asList("CHI")));
        mon.setRegion("Asia");
        underTestCountryList.add(mon);

        Country nko = new Country();
        nko.setCca3("NKO");
        nko.setBorderSet(new HashSet<>(Arrays.asList("SKO")));
        nko.setRegion("Asia");
        underTestCountryList.add(nko);

        Country sko = new Country();
        sko.setCca3("SKO");
        sko.setBorderSet(new HashSet<>(Arrays.asList("NKO")));
        sko.setRegion("Asia");
        underTestCountryList.add(sko);

        Country vie = new Country();
        vie.setCca3("VIE");
        vie.setBorderSet(new HashSet<>(Arrays.asList("CHI", "LAO", "CAM")));
        vie.setRegion("Asia");
        underTestCountryList.add(vie);

        Country cam = new Country();
        cam.setCca3("CAM");
        cam.setBorderSet(new HashSet<>(Arrays.asList("VIE", "LAO")));
        cam.setRegion("Asia");
        underTestCountryList.add(cam);

        Country lao = new Country();
        lao.setCca3("LAO");
        lao.setBorderSet(new HashSet<>(Arrays.asList("CHI", "VIE", "CAM")));
        lao.setRegion("Asia");
        underTestCountryList.add(lao);


        return underTestCountryList;

    }
}