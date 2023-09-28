package com.sathish.cruddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoRestController {
    @GetMapping("/")
    public String home(){
        return "<center><h1> Welcome to Home Page</h1></center>";
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello there..";
    }
}
