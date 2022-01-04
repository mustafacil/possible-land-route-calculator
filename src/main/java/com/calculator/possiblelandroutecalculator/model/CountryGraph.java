package com.calculator.possiblelandroutecalculator.model;

import java.util.*;

/**
 * This class represents a Graph of countries in the same region.
 */
public class CountryGraph {

    //The country list in the same region
    private List<Country> countryList;
    //The Adjacency Matrix between countries
    private int[][] adjacencyMatrix;
    //Breadth First Search Queue
    private Queue<Integer> breadthFirstSearchQueue;
    //Stores all visited countries from origin to destination.
    private Stack<Integer> visitedCountryStack;

    /**
     * CountryGraph Constructor
     * Creates Adjacency Matrix
     * Instantiates Queue and Stack
     *
     * @param countryList The list of {@link Country} in the graph.
     */
    public CountryGraph(List<Country> countryList) {
        this.countryList = countryList;
        adjacencyMatrix = new int[countryList.size()][countryList.size()];
        createAdjacencyMatrixFromCountryList();
        breadthFirstSearchQueue = new LinkedList<>();
        visitedCountryStack = new Stack<>();
    }

    /**
     * Function to create a map with a
     * {@link Country} name as the key and
     * country index in country list as the value
     *
     * @return Map with countries and their indexes within the list
     */
    public Map<String, Integer> getCountryIndexMap() {

        Map<String, Integer> countryIndexMap = new HashMap<>();

        for (int i = 0; i < countryList.size(); i++) {
            countryIndexMap.put(countryList.get(i).getCca3(), i);
        }

        return countryIndexMap;
    }

    /**
     * Function to create Adjacency Matrix
     * of countries in same region
     */
    private void createAdjacencyMatrixFromCountryList() {

        Map<String, Integer> countryIndexMap = getCountryIndexMap();
        for (int i = 0; i < countryList.size(); i++) {

            Country country = countryList.get(i);
            Set<String> borderList = country.getBorders();

            for (String border : borderList) {

                /*
                If a border of current country is not
                in the country list or countryIndexMap then continue
                 */
                if (!countryIndexMap.containsKey(border)) {
                    continue;
                }

                //Get border index in country list
                int borderIndexInCountryList = countryIndexMap.get(border);
                //Set current country and its border as adjacent
                adjacencyMatrix[i][borderIndexInCountryList] = 1;
                adjacencyMatrix[borderIndexInCountryList][i] = 1;
            }

        }

    }

    /**
     * Function to retrieve unvisited countries
     * while finding a route
     * @param indexNumber of the {@link Country} to find unvisited neighbors.
     * @return first unvisited adjacent {@link Country} index of current {@link Country}
     * if all adjacent countries were visited return -1
     */
    public int getUnvisitedCountryIndex(int indexNumber) {

        /*
        if the countries are adjacent and the adjacent country is unvisited,
        return adjacent country index otherwise return -1
         */
        for (int i = 0; i < countryList.size(); i++) {

            if (adjacencyMatrix[indexNumber][i] == 1 && countryList.get(i).isWasVisited() == false) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Function to breadth first search on a country graph
     * @param fromIndex of origin {@link Country} index in country list
     * @param toIndex of destination {@link Country} index in country list
     */
    public void breathFirstSearch(int fromIndex, int toIndex) {
        //set origin country was visited and add to queue
        countryList.get(fromIndex).setWasVisited(true);
        breadthFirstSearchQueue.offer(fromIndex);
        int borderUnVisitedIndex;

        while (!breadthFirstSearchQueue.isEmpty()) {

            int visitedCountryIndex = breadthFirstSearchQueue.poll();
            //add the country to stack to save the route
            visitedCountryStack.push(visitedCountryIndex);

            while ((borderUnVisitedIndex = getUnvisitedCountryIndex(visitedCountryIndex)) != -1) {
                //If destination can be reached from the origin return true.
                if (toIndex == borderUnVisitedIndex) {
                    return;
                }
                //set border country was visited and add to queue
                countryList.get(borderUnVisitedIndex).setWasVisited(true);
                breadthFirstSearchQueue.offer(borderUnVisitedIndex);

            }

        }

    }

    /**
     * Function to find a route between origin and destination country
     * It uses visited country stack to find the route
     * @param origin is the name origin {@link Country}
     * @param destination is the name destination {@link Country}
     * @return List of countries names that represent the route from origin to destination.
     */
    public List<String> findRoute(String origin, String destination) {

        List<String> routeList = new LinkedList<>();

        int originIndex = getCountryIndexMap().get(origin);
        int destinationIndex = getCountryIndexMap().get(destination);
        breathFirstSearch(originIndex, destinationIndex);

        //Firstly, add the destination country name to route list.
        routeList.add(countryList.get(destinationIndex).getCca3());
        //Set current country as the top of visited country stack.
        Country currentCountry = countryList.get(visitedCountryStack.pop());
        //Secondly, add the current country name of destination country to route list.
        routeList.add(currentCountry.getCca3());

        while (!visitedCountryStack.isEmpty()) {

            Set<String> currentCountryBorderList = currentCountry.getBorders();
            //Retrieve the country which is in the top of visited country stack.
            String topCountryCca3InStack = countryList.get(visitedCountryStack.peek()).getCca3();

            /*
            Check the country which is in the top of visited country stack is adjacent with current country.
            If they are adjacent add the visited country to route list.
             */
            if (currentCountryBorderList.contains(topCountryCca3InStack)) {

                routeList.add(topCountryCca3InStack);
                currentCountry = countryList.get(visitedCountryStack.pop());
                continue;
            }

            if (visitedCountryStack.size() > 0) {
                visitedCountryStack.pop();
            }

        }
        //To provide a route from origin to destination,
        // route list needs to be reversed
        Collections.reverse(routeList);
        return routeList;
    }


    /**
     * Function to set visited to false,
     * clear queue and clear stack to calculate a new route.
     */
    public void refreshGraph() {

        countryList.forEach(country -> country.setWasVisited(false));
        breadthFirstSearchQueue.clear();
        visitedCountryStack.clear();

    }

    /**
     * Function to return the {@link Country} adjacency matrix
     * @return the adjacency matrix
     */
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * Function to return visited {@link Country} stack
     * @return the visited {@link Country} stack
     */
    public Stack<Integer> getVisitedCountryStack() {
        return visitedCountryStack;
    }

    /**
     * Function to return Breadth First Search Queue
     * @return Breadth First Search Queue
     */
    public Queue<Integer> getBreadthFirstSearchQueue() {
        return breadthFirstSearchQueue;
    }

    /**
     * Function to return {@link Country} list
     * @return {@link Country} list
     */
    public List<Country> getCountryList() {
        return countryList;
    }
}
