package com.calculator.possiblelandroutecalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountryGraphTest {

    private CountryGraph europeCountryGraph;

    @BeforeEach
    void setUp(){

        List<Country> europeCountryList = getUnderTestEuropeRegionCountryList();
        europeCountryGraph = new CountryGraph(europeCountryList);

    }

    @DisplayName("Test that the map contains country name as the key and country index in the list as the value")
    @Test
    void shouldGetCountryIndexMap_WithGivenCountryList() {

        //Given
        List<Country> underTestCountryList = getUnderTestCountryList();

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("GER", 0);
        expectedMap.put("AUS", 1);
        expectedMap.put("NTH", 2);
        expectedMap.put("HUN", 3);
        expectedMap.put("ITL", 4);
        expectedMap.put("FRA", 5);
        expectedMap.put("BLG", 6);
        expectedMap.put("SWZ", 7);
        expectedMap.put("PLN", 8);
        expectedMap.put("LXM", 9);
        expectedMap.put("CHI", 10);
        expectedMap.put("MON", 11);
        expectedMap.put("NKO", 12);
        expectedMap.put("SKO", 13);
        expectedMap.put("VIE", 14);
        expectedMap.put("CAM", 15);
        expectedMap.put("LAO", 16);

        //When
        CountryGraph countryGraph = new CountryGraph(underTestCountryList);
        Map<String, Integer> actualMap = countryGraph.getCountryIndexMap();

        //Then
        assertEquals(expectedMap, actualMap);


    }

    @DisplayName("Test the adjacency matrix between countries are in the same region")
    @Test
    void shouldCreateAdjacencyMatrix_WithGivenCountryList() {

        //Expected
        int[][] expectedEuropeRegionAdjacencyMatrix = new int[][]{
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},//0
                {1, 0, 0, 1, 0, 1, 1, 0, 0, 0},//1
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},//2
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},//3
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},//4
                {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},//5
                {0, 1, 0, 0, 0, 1, 0, 1, 0, 0},//6
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},//7
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},//8
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}//9
        };

        //Given

        //When
        int[][] actualEuropeRegionAdjacencyMatrix = europeCountryGraph.getAdjacencyMatrix();

        //Then
        assertArrayEquals(expectedEuropeRegionAdjacencyMatrix, actualEuropeRegionAdjacencyMatrix);

    }

    @DisplayName("Test the unvisited country index with given a country index")
    @Test
    void shouldGetUnvisitedCountryIndex_WithGivenCountryIndexNumber() {

        
        assertAll(
                () -> assertEquals(1, europeCountryGraph.getUnvisitedCountryIndex(0)),
                () -> assertEquals(0, europeCountryGraph.getUnvisitedCountryIndex(1)),
                () -> assertEquals(0, europeCountryGraph.getUnvisitedCountryIndex(2)),
                () -> assertEquals(1, europeCountryGraph.getUnvisitedCountryIndex(3)),
                () -> assertEquals(3, europeCountryGraph.getUnvisitedCountryIndex(4)),
                () -> assertEquals(1, europeCountryGraph.getUnvisitedCountryIndex(5)),
                () -> assertEquals(1, europeCountryGraph.getUnvisitedCountryIndex(6)),
                () -> assertEquals(6, europeCountryGraph.getUnvisitedCountryIndex(7)),
                () -> assertEquals(2, europeCountryGraph.getUnvisitedCountryIndex(8)),
                () -> assertEquals(2, europeCountryGraph.getUnvisitedCountryIndex(9))
        );


    }

    @DisplayName("Test the visited country stack with given origin and destination")
    @Test
    void shouldFillVisitedCountryStack_WithBreathFirstSearchGivenOriginAndDestination(){

        //Expected
        Stack<Integer> expectedVisitedCountryStack = new Stack<>();
        expectedVisitedCountryStack.push(0);
        expectedVisitedCountryStack.push(1);
        expectedVisitedCountryStack.push(2);
        expectedVisitedCountryStack.push(3);
        expectedVisitedCountryStack.push(5);
        expectedVisitedCountryStack.push(6);

        //Given

        //When
        europeCountryGraph.breathFirstSearch(0, 7);
        Stack<Integer> actualVisitedCountryStack = europeCountryGraph.getVisitedCountryStack();

        //Then
        assertEquals(expectedVisitedCountryStack, actualVisitedCountryStack);


    }

    @DisplayName("Get Route List With Given Origin and Destination")
    @Test
    void shouldFindTheRoute_WithGivenOriginAndDestination(){

        //Expected
        List<String> expectedRouteList = Arrays.asList("GER", "AUS", "FRA", "BLG", "SWZ");

        //Given

        //When
        List<String> actualRouteList = europeCountryGraph.findRoute("GER", "SWZ");
        //Then
        assertEquals(expectedRouteList, actualRouteList);
    }

    @DisplayName("All Countries should be unvisited after refreshing the graph")
    @Test
    void shouldSetTheVisitedCountryToUnvisitedAfterARouteFounded(){

        //Expected
        int numberOfExpectedUnvisitedCountry = 10;

        //Given

        //When
        europeCountryGraph.findRoute("GER", "SWZ");
        europeCountryGraph.refreshGraph();

        List<Country> countryList = europeCountryGraph.getCountryList();

        int numberOfActualUnvisitedCountry = (int)countryList.stream().filter(country -> !country.isWasVisited()).count();

        //Then
        assertEquals(numberOfExpectedUnvisitedCountry, numberOfActualUnvisitedCountry);
    }

    @DisplayName("Visited Country Stack should be cleared after refreshing the graph")
    @Test
    void shouldClearVisitedCountryStackAfterARouteFounded(){
        //Given

        //When
        europeCountryGraph.findRoute("GER", "SWZ");
        europeCountryGraph.refreshGraph();

        Stack<Integer> visitedCountryStack = europeCountryGraph.getVisitedCountryStack();

        //Then
        assertEquals(0, visitedCountryStack.size());

    }

    @DisplayName("Breadth First Search Queue should be cleared after refreshing the graph")
    @Test
    void shouldClearBreadthFirstSearchQueueAfterARouteFounded(){

        //Given

        //When
        europeCountryGraph.findRoute("GER", "SWZ");
        europeCountryGraph.refreshGraph();

        Queue<Integer> breadthFirstSearchQueue = europeCountryGraph.getBreadthFirstSearchQueue();

        //Then
        assertEquals(0, breadthFirstSearchQueue.size());

    }


    public List<Country> getUnderTestEuropeRegionCountryList() {

        List<Country> underTestCountryList = getUnderTestCountryList();
        return underTestCountryList.stream().filter(country -> country.getRegion().equals("Europe")).collect(Collectors.toList());

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


