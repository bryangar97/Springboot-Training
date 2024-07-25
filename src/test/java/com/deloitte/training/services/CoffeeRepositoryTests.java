package com.deloitte.training.services;

import com.deloitte.training.entities.Coffee;
import com.deloitte.training.repositories.CoffeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CoffeeRepositoryTests {

  @Mock
  CoffeeRepository coffeeRepository;

  @Test
  public void whenGetAllCoffees_thenVerifyLength() {
    List<Coffee> mockedCoffeeIterable = List.of(
        new Coffee("Cappuccino Coffee"),
        new Coffee("Espresso Coffee"),
        new Coffee("Oxxo Coffee")
    );

    when(coffeeRepository.findCoffees()).thenReturn(mockedCoffeeIterable);

    List<Coffee> coffeeIterable = (List<Coffee>) coffeeRepository.findCoffees();

    assertEquals(mockedCoffeeIterable.size(), coffeeIterable.size());
  }

}
