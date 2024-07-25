package com.deloitte.training.controllers;

import com.deloitte.training.entities.Coffee;
import com.deloitte.training.services.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {

    CoffeeService coffeeService;

    public RestApiDemoController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    Iterable<Coffee> getCoffees() {
        return this.coffeeService.getCoffees();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return this.coffeeService.findCoffeeById(id);
    }

    @PostMapping
    ResponseEntity<Coffee> postCoffee(@RequestBody Coffee coffee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coffeeService.createCoffee(coffee));
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id,
                                     @RequestBody Coffee coffee) {

        Coffee updatedCoffee = this.coffeeService.updateCoffeeById(id, coffee);

        return (Objects.isNull(updatedCoffee)) ?
                postCoffee(coffee) :
                new ResponseEntity<>(updatedCoffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        this.coffeeService.deleteCoffeeById(id);
    }
}