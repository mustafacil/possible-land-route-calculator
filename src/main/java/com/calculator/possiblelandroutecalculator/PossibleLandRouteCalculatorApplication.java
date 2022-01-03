package com.calculator.possiblelandroutecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PossibleLandRouteCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PossibleLandRouteCalculatorApplication.class, args);
    }

}
