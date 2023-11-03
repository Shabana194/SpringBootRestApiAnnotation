package com.example.firstappspringboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")     //http://localhost:9090/hello-world
    public String helloWorld(){
        return "Hello";
    }
}
