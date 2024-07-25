package com.deloitte.training.controllers;

import com.deloitte.training.entities.Coffee;
import com.deloitte.training.services.CoffeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(controllers = RestApiDemoController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class RestApiDemoControllerTests {

  MockMvc mockMvc;
  ObjectMapper objectMapper;

  @MockBean
  CoffeeService coffeeService;


  List<Coffee> mockedCoffeList;
  Coffee mockedOxxoCoffee;
  @Autowired
  public RestApiDemoControllerTests(MockMvc mockMvc, ObjectMapper objectMapper) {
    this.mockMvc = mockMvc;
    this.objectMapper = objectMapper;
  }


  @BeforeEach
  public void init() {
    mockedOxxoCoffee = new Coffee("Oxxo Coffee");
    mockedCoffeList = List.of(mockedOxxoCoffee, new Coffee("Cappuccino Coffee"), new Coffee("Espresso Coffee"));
  }

  @Test
  public void whenGetAllCoffees_thenVerifyStatusCode() throws Exception {

    when(coffeeService.getCoffees()).thenReturn(mockedCoffeList);

    ResultActions response = mockMvc.perform(
        get("/coffees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(mockedCoffeList))
    );
    response.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.length()", CoreMatchers.is( mockedCoffeList.size())));
  }

  @Test
  public void whenGetCoffeeById_thenVerifyCoffeeName() throws Exception {

    when(coffeeService.findCoffeeById(any())).thenReturn(Optional.of(mockedOxxoCoffee));


    ResultActions response = mockMvc.perform(
        get("/coffees/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(mockedOxxoCoffee))
    );

    response.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is( mockedOxxoCoffee.getName())));
  }

  @Test
  public void whenCreateCoffee_thenVerifyCreatedCoffee() throws Exception {

    when(coffeeService.createCoffee(any())).thenReturn(mockedOxxoCoffee);


    ResultActions response = mockMvc.perform(
        post("/coffees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(mockedOxxoCoffee))
    );

    response.andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is( mockedOxxoCoffee.getName())));
  }


}