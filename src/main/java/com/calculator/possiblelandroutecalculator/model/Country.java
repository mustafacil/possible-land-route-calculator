package com.calculator.possiblelandroutecalculator.model;

import java.util.List;

public class Country {

    private String cca3;
    private List<String> borderList;
    private boolean wasVisited;

    public Country() {
    }

    public Country(String cca3, List<String> borderList, boolean wasVisited) {
        this.cca3 = cca3;
        this.borderList = borderList;
        this.wasVisited = wasVisited;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public List<String> getBorderList() {
        return borderList;
    }

    public void setBorderList(List<String> borderList) {
        this.borderList = borderList;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
