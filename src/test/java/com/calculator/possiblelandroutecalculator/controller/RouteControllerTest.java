package com.calculator.possiblelandroutecalculator.controller;


import com.calculator.possiblelandroutecalculator.service.CountryGraphService;
import com.calculator.possiblelandroutecalculator.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RouteController.class)
class RouteControllerTest {

    private final static String CONTENT_TYPE = "application/json";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CountryService countryService;

    @MockBean
    private CountryGraphService countryGraphService;

    @Test
    void shouldReturnBadRequest_WithGivenOriginAndDestinationCountryAreNotInSameRegion() throws Exception {
        //Given
        Mockito.when(countryService.countriesAreInSameRegion("DEU", "AUS")).thenReturn(false);

        //When
        ResultActions resultActions = mockMvc.perform(get("/routing/DEU/AUS"));

        //Then
        Mockito.verify(countryService, Mockito.times(1)).countriesAreInSameRegion("DEU", "AUS");

        resultActions.andExpect(status().isBadRequest());

    }

    @Test
    void shouldReturnBadRequest_WithGivenInvalidOriginOrDestinationCountry() throws Exception {

        //Given
        Mockito.when(countryGraphService.findRoute("DEU", "XXX")).thenReturn(new LinkedList<>());

        //When
        ResultActions resultActions= mockMvc.perform(get("/routing/DEU/XXX"));

        //Then
        Mockito.verify(countryService, Mockito.times(1)).countriesAreInSameRegion("DEU", "XXX");

        resultActions.andExpect(status().isBadRequest());

    }

    @Test
    void shouldReturnOK_WithGivenValidOriginAndDestinationCountryAndThereIsARouteBetweenThem() throws Exception {

        List<String> routeList = Arrays.asList("CZE", "AUT", "ITA");

        //Given
        Mockito.when(countryService.countriesAreInSameRegion("CZE", "ITA")).thenReturn(true);
        Mockito.when(countryGraphService.findRoute("CZE", "ITA")).thenReturn(routeList);


        //When
        MvcResult mvcResult = mockMvc.perform(get("/routing/CZE/ITA").accept(CONTENT_TYPE)).andReturn();

        //Then
        String responseBody = mvcResult.getResponse().getContentAsString();
        Mockito.verify(countryGraphService, Mockito.times(1)).findRoute("CZE", "ITA");
        assertThat(objectMapper.writeValueAsString(routeList)).isEqualToIgnoringWhitespace(responseBody);
    }

}