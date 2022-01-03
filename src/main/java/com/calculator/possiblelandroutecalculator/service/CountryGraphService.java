package com.calculator.possiblelandroutecalculator.service;

import java.util.List;

/**
 * Country graph service interface
 */
public interface CountryGraphService {

    List<String> findRoute(String origin, String destination);
}
