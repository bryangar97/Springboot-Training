package com.deloitte.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicController {

  @GetMapping("/public/greeting")
  public String greeting() {
    return "Hello from public endpoint!";
  }

  @GetMapping("/user/greeting")
  public String userGreeting() {
    return "Hello from user endpoint!";
  }

  @GetMapping("/admin/greeting")
  public String adminGreeting() {
    return "Hello from admin endpoint!";
  }
}
