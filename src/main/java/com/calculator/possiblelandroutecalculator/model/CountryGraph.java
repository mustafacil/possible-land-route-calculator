package com.calculator.possiblelandroutecalculator.model;

import java.util.*;

public class CountryGraph {

    private List<Country> countryList;
    private int[][] adjacencyMatrix;
    private Queue<Integer> queue;
    private Stack<Integer> stack;

    public CountryGraph(List<Country> countryList) {
        this.countryList = countryList;
        adjacencyMatrix = new int[countryList.size()][countryList.size()];
        queue = new LinkedList<>();
        stack = new Stack<>();

        createAdjacentMatrixFromCountryList();
    }


    public Map<String, Integer> getCountryMap() {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < countryList.size(); i++) {
            map.put(countryList.get(i).getCca3(), i);
        }

        return map;
    }

    public void createAdjacentMatrixFromCountryList() {

        Map<String, Integer> map = getCountryMap();

        for (int i = 0; i < countryList.size(); i++) {

            Country country = countryList.get(i);
            Set<String> borderList = country.getBorderSet();

            for (String border : borderList) {

                int borderIndexInCountryList = map.get(border);
                adjacencyMatrix[i][borderIndexInCountryList] = 1;
                adjacencyMatrix[borderIndexInCountryList][i] = 1;
            }

        }

    }

    public int getUnvisitedCountryIndex(int indexNumber) {

        for (int i = 0; i < countryList.size(); i++) {

            if (adjacencyMatrix[indexNumber][i] == 1 && countryList.get(i).isWasVisited() == false) {
                return i;
            }

        }

        return -1;
    }

    public boolean breathFirstSearch(int fromIndex, int toIndex) {

        countryList.get(fromIndex).setWasVisited(true);
        queue.offer(fromIndex);
        int borderUnVisitedIndex;

        while (!queue.isEmpty()) {

            int visitedCountryIndex = queue.poll();
            stack.push(visitedCountryIndex);

            while ((borderUnVisitedIndex = getUnvisitedCountryIndex(visitedCountryIndex)) != -1) {

                if (toIndex == borderUnVisitedIndex) {
                    System.out.println("Bulundu: " + countryList.get(toIndex).getCca3());
                    displayStack(stack);
                    return true;
                }

                countryList.get(borderUnVisitedIndex).setWasVisited(true);
                queue.offer(borderUnVisitedIndex);


            }

        }

        return false;
    }

    public List<String> findRoute(String from, String to) {

        List<String> resultList = new LinkedList<>();

        int fromIndex = getCountryMap().get(from);
        int toIndex = getCountryMap().get(to);


        boolean isRouteFound = breathFirstSearch(fromIndex, toIndex);

        if (!isRouteFound) {
            return resultList;
        }

        resultList.add(countryList.get(toIndex).getCca3());
        Country currentCountry = countryList.get(stack.pop());
        resultList.add(currentCountry.getCca3());

        while (!stack.isEmpty()) {

            Set<String> currentCountryBorderList = currentCountry.getBorderSet();

            String topCountryCca3InStack = countryList.get(stack.peek()).getCca3();

            if (currentCountryBorderList.contains(topCountryCca3InStack)) {

                resultList.add(topCountryCca3InStack);
                currentCountry = countryList.get(stack.pop());
                continue;
            }

            if (stack.size() > 0) {
                stack.pop();
            }

        }
        return resultList;
    }

    public List<String> getRoute(String from, String to){

        List<String> routeList = findRoute(from, to);
        Collections.reverse(routeList);
        return routeList;

    }

    public void displayStack(Stack<Integer> stack) {

        Object[] arr = stack.toArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(countryList.get((Integer) arr[i]).getCca3());
        }

    }
}
