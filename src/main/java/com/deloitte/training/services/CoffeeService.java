package com.deloitte.training.services;

import com.deloitte.training.entities.Coffee;
import com.deloitte.training.repositories.CoffeeRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CoffeeService {

  private final CoffeeRepository coffeeRepository;
  public CoffeeService(CoffeeRepository coffeeRepository) {
    this.coffeeRepository = coffeeRepository;
  }

  public Iterable<Coffee> getCoffees() {
    return this.coffeeRepository.findCoffees();
  }

  public Optional<Coffee> findCoffeeById(String id) {
    return this.coffeeRepository.findCoffeeById(id);
  }

  public Coffee createCoffee(Coffee coffee) {
    return this.coffeeRepository.createCoffee(coffee);
  }

  public Coffee updateCoffeeById(String id, Coffee coffee) {
    return this.coffeeRepository.updateCoffeeById(id, coffee);
  }

  public void deleteCoffeeById(String id) {
    this.coffeeRepository.deleteCoffeeById(id);
  }
}
