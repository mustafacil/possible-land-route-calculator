package com.calculator.possiblelandroutecalculator.model;

import java.util.HashMap;
import java.util.Map;

public class SingletonCountryByRegionMap {

    private static Map<String, String> singletonCountryByRegionMap = new HashMap<>();

    private SingletonCountryByRegionMap(){

    }

    public static Map<String, String> getInstance(){
        return singletonCountryByRegionMap;
    }

    public static void setInstance(Map<String, String> countryByRegionMap){
        singletonCountryByRegionMap = countryByRegionMap;
    }
}
