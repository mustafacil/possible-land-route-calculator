package com.calculator.possiblelandroutecalculator.controller;

import com.calculator.possiblelandroutecalculator.service.CountryGraphService;
import com.calculator.possiblelandroutecalculator.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/routing")
public class RouteController {

    private final CountryService countryService;
    private final CountryGraphService countryGraphService;

    public RouteController(CountryService countryService, CountryGraphService countryGraphService) {
        this.countryService = countryService;
        this.countryGraphService = countryGraphService;
    }

    /**
     * Function to get route list
     * @param origin country
     * @param destination country
     * @return route list if exists
     */
    @GetMapping(value = "/{origin}/{destination}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getPossibleRoute(@PathVariable("origin") String origin, @PathVariable("destination") String destination){

        boolean areCountriesInSameRegion = countryService.countriesAreInSameRegion(origin, destination);

        if(!areCountriesInSameRegion){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<String> route = countryGraphService.findRoute(origin, destination);

        if(route.size() == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(route, HttpStatus.OK);
    }

}
