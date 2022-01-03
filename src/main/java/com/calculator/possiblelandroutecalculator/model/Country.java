package com.calculator.possiblelandroutecalculator.model;

import java.util.Set;

/**
 * This class represents a country.
 */
public class Country {

    //Country name
    private String cca3;
    //Country border set
    private Set<String> borders;
    //Was visited when finding a route?
    private boolean wasVisited;
    //The region to which the country belongs.
    private String region;

    public Country() {
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public Set<String> getBorders() {
        return borders;
    }

    public void setBorders(Set<String> borders) {
        this.borders = borders;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Function to check that the otherCountry is in the same region or not.
     * @param otherCountry is the country to be checked.
     * @return if two countries are in the same region.
     */
    public boolean isInSameRegionWith(Country otherCountry){

        boolean isInSameRegion = false;

        if(this.region.equals(otherCountry.getRegion())){
            isInSameRegion = true;
        }

        return isInSameRegion;

    }

    @Override
    public String toString() {
        return "Country{" +
                "cca3='" + cca3 + '\'' +
                ", borders=" + borders +
                ", wasVisited=" + wasVisited +
                ", region='" + region + '\'' +
                '}';
    }
}
