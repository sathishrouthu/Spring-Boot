package com.sathish.restcrud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("/")
    public String home(){
        return "Home";
    }
}
