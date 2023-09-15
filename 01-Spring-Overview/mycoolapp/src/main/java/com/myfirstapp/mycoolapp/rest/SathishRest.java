package com.myfirstapp.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SathishRest {
    @Value("${dog.name}")
    private String DogName;
    @Value("${squad.name}")
    private String squadName;
    @GetMapping("/")
    public String sayHello(){
        return "Hellooo sathish  .!!! "+DogName+"  is In  "+squadName;
    }
}
