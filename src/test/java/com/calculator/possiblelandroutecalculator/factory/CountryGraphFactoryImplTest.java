package com.calculator.possiblelandroutecalculator.factory;

import com.calculator.possiblelandroutecalculator.model.Country;
import com.calculator.possiblelandroutecalculator.model.CountryGraph;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CountryGraphFactoryImplTest {

    @Test
    void shouldCreateCountryGraphMapByRegion_WithGivenCountryListMapByRegion() {

        //Given
        Map<String, List<Country>> underTestCountryGraphMap = getUnderTestCountryGraphMap();

        //When
        CountryGraphFactory countryGraphFactory = new CountryGraphFactoryImpl();
        Map<String, CountryGraph> actualGraphMap = countryGraphFactory.getCountryGraphMapByRegion(underTestCountryGraphMap);

        //Then
        assertEquals(2, actualGraphMap.size());

    }

    public Map<String, List<Country>> getUnderTestCountryGraphMap() {

        List<Country> europeRegionCountryList = new LinkedList<>();

        Country ger = new Country();
        ger.setCca3("GER");
        ger.setBorders(new HashSet<>(Arrays.asList("AUS", "NTH")));
        ger.setRegion("Europe");
        europeRegionCountryList.add(ger);


        Country aus = new Country();
        aus.setCca3("AUS");
        aus.setBorders(new HashSet<>(Arrays.asList("GER", "HUN", "FRA", "BLG")));
        aus.setRegion("Europe");
        europeRegionCountryList.add(aus);

        Country nth = new Country();
        nth.setCca3("NTH");
        nth.setBorders(new HashSet<>(Arrays.asList("GER", "PLN", "LXM")));
        nth.setRegion("Europe");
        europeRegionCountryList.add(nth);

        Country hun = new Country();
        hun.setCca3("HUN");
        hun.setBorders(new HashSet<>(Arrays.asList("AUS", "ITL")));
        hun.setRegion("Europe");
        europeRegionCountryList.add(hun);

        Country itl = new Country();
        itl.setCca3("ITL");
        itl.setBorders(new HashSet<>(Arrays.asList("HUN")));
        itl.setRegion("Europe");
        europeRegionCountryList.add(itl);

        Country fra = new Country();
        fra.setCca3("FRA");
        fra.setBorders(new HashSet<>(Arrays.asList("AUS", "BLG")));
        fra.setRegion("Europe");
        europeRegionCountryList.add(fra);

        Country blg = new Country();
        blg.setCca3("BLG");
        blg.setBorders(new HashSet<>(Arrays.asList("AUS", "FRA", "SWZ")));
        blg.setRegion("Europe");
        europeRegionCountryList.add(blg);

        Country swz = new Country();
        swz.setCca3("SWZ");
        swz.setBorders(new HashSet<>(Arrays.asList("BLG")));
        swz.setRegion("Europe");
        europeRegionCountryList.add(swz);

        Country pln = new Country();
        pln.setCca3("PLN");
        pln.setBorders(new HashSet<>(Arrays.asList("NTH")));
        pln.setRegion("Europe");
        europeRegionCountryList.add(pln);

        Country lxm = new Country();
        lxm.setCca3("LXM");
        lxm.setBorders(new HashSet<>(Arrays.asList("NTH", "SPA")));
        lxm.setRegion("Europe");
        europeRegionCountryList.add(lxm);

        List<Country> asiaRegionCountryList = new LinkedList<>();

        Country chi = new Country();
        chi.setCca3("CHI");
        chi.setBorders(new HashSet<>(Arrays.asList("MON", "NKO", "VIE", "LAO")));
        chi.setRegion("Asia");
        asiaRegionCountryList.add(chi);

        Country mon = new Country();
        mon.setCca3("MON");
        mon.setBorders(new HashSet<>(Arrays.asList("CHI")));
        mon.setRegion("Asia");
        asiaRegionCountryList.add(mon);

        Country nko = new Country();
        nko.setCca3("NKO");
        nko.setBorders(new HashSet<>(Arrays.asList("SKO")));
        nko.setRegion("Asia");
        asiaRegionCountryList.add(nko);

        Country sko = new Country();
        sko.setCca3("SKO");
        sko.setBorders(new HashSet<>(Arrays.asList("NKO")));
        sko.setRegion("Asia");
        asiaRegionCountryList.add(sko);

        Country vie = new Country();
        vie.setCca3("VIE");
        vie.setBorders(new HashSet<>(Arrays.asList("CHI", "LAO", "CAM")));
        vie.setRegion("Asia");
        asiaRegionCountryList.add(vie);

        Country cam = new Country();
        cam.setCca3("CAM");
        cam.setBorders(new HashSet<>(Arrays.asList("VIE", "LAO")));
        cam.setRegion("Asia");
        asiaRegionCountryList.add(cam);

        Country lao = new Country();
        lao.setCca3("LAO");
        lao.setBorders(new HashSet<>(Arrays.asList("CHI", "VIE", "CAM")));
        lao.setRegion("Asia");
        asiaRegionCountryList.add(lao);

        Map<String, List<Country>> underTestCountryGraphMapByRegion = new HashMap<>();
        underTestCountryGraphMapByRegion.put("Europe", europeRegionCountryList);
        underTestCountryGraphMapByRegion.put("Asia", asiaRegionCountryList);
        return underTestCountryGraphMapByRegion;

    }

}