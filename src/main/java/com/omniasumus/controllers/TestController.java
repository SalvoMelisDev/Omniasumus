package com.omniasumus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") // Base path per tutti gli endpoint in questo controller
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Ciao, mondo!";
    }

    @GetMapping("/user")
    public String getUser() {
        return "{\"username\": \"testuser\", \"email\": \"testuser@example.com\"}";
    }
}