package com.calculator.possiblelandroutecalculator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonCountryListMapByRegion {

    private static Map<String, List<Country>> singletonCountryListMapByRegion = new HashMap<>();

    private SingletonCountryListMapByRegion(){

    }

    public static Map<String, List<Country>> getInstance(){
        return singletonCountryListMapByRegion;
    }

    public static void setInstance(Map<String, List<Country>> countryListMapByRegion){
        singletonCountryListMapByRegion = countryListMapByRegion;
    }

}
