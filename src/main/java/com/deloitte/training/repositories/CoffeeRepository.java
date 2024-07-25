package com.deloitte.training.repositories;

import com.deloitte.training.entities.Coffee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CoffeeRepository {

  private final List<Coffee> coffees = new ArrayList<>();

  public CoffeeRepository() {
    coffees.addAll(List.of(
        new Coffee("Café Cereza"),
        new Coffee("Café Ganador"),
        new Coffee("Café Lareño"),
        new Coffee("Café Três Pontas")
    ));
  }
  public Iterable<Coffee> findCoffees() {
    return this.coffees;
  }
  public Optional<Coffee> findCoffeeById(String id) {
    return coffees.stream().filter(coffee -> Objects.equals(coffee.getId(), id) ).findFirst().or(Optional::empty);
  }

  public Coffee createCoffee(Coffee coffee) {
    this.coffees.add(coffee);
    return coffees.get(coffees.size() - 1);
  }

  public Coffee updateCoffeeById(String id, Coffee coffee) {
    int coffeeIndex = -1;

    for (Coffee c: this.coffees) {
      if (c.getId().equals(id)) {
        coffeeIndex = coffees.indexOf(c);
        coffees.set(coffeeIndex, coffee);
      }
    }
    if(coffeeIndex == -1) return null;

    return this.coffees.get(coffeeIndex);
  }

  public void deleteCoffeeById(String id) {
    this.coffees.removeIf(coffee -> Objects.equals(coffee.getId(), id));
  }

}
