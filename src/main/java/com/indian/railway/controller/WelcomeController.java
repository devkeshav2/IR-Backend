package com.indian.railway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    // Map GET request for "/hello"
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Railway!";
    }
}
