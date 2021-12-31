package com.calculator.possiblelandroutecalculator.model;

import java.util.List;
import java.util.Set;

public class Country {

    private String cca3;
    private Set<String> borderSet;
    private boolean wasVisited;

    public Country() {
    }

    public Country(String cca3, Set<String> borderSet, boolean wasVisited) {
        this.cca3 = cca3;
        this.borderSet = borderSet;
        this.wasVisited = wasVisited;
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
}
