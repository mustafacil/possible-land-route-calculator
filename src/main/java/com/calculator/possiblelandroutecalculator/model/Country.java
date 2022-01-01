package com.calculator.possiblelandroutecalculator.model;

import java.util.Set;

public class Country {

    private String cca3;
    private Set<String> borderSet;
    private boolean wasVisited;
    private String region;

    public Country() {
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public Set<String> getBorderSet() {
        return borderSet;
    }

    public void setBorderSet(Set<String> borderSet) {
        this.borderSet = borderSet;
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

    public boolean isInSameRegion(Country otherCountry){

        boolean isInSameRegion = false;

        if(this.region.equals(otherCountry.getRegion())){
            isInSameRegion = true;
        }

        return isInSameRegion;

    }
}
