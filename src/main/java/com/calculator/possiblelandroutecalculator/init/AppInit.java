package com.calculator.possiblelandroutecalculator.init;

import com.calculator.possiblelandroutecalculator.factory.CountryMapFactory;
import com.calculator.possiblelandroutecalculator.factory.CountryMapFactoryImpl;
import com.calculator.possiblelandroutecalculator.model.Country;
import com.calculator.possiblelandroutecalculator.model.SingletonCountryByRegionMap;
import com.calculator.possiblelandroutecalculator.model.SingletonCountryListMapByRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppInit implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppInit.class);

    private final CountryMapFactory countryMapFactory;

    public AppInit(CountryMapFactory countryMapFactory) {
        this.countryMapFactory = countryMapFactory;
    }

    @Override
    public void run(String... args) throws Exception {

        Map<String, String> countryByRegionMap = countryMapFactory.getCountryMapByRegion();
        Map<String, List<Country>> countryListMapByRegion = countryMapFactory.getCountryListMapByRegion();

        SingletonCountryByRegionMap.setInstance(countryByRegionMap);
        SingletonCountryListMapByRegion.setInstance(countryListMapByRegion);

        logger.info("Maps was initiated: countryByRegionMap size : " + countryByRegionMap.size() + " countryListMapByRegion size: " + countryListMapByRegion.size());



    }
}
