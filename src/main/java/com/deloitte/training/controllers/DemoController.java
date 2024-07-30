package com.deloitte.training.controllers;

import com.deloitte.training.common.Coach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private final Coach myCoach;
    private final Logger log = LoggerFactory.getLogger(getClass());

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping()
    public String helloWorld() {
        log.error("Error level Log");
        log.info("Info level Log");
        log.debug("Info level Log");
        return "Hello World";
    }
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
