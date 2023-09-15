package com.sathish.springcoredemo.controller;

import com.sathish.springcoredemo.utilInterfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach1;
    private Coach coach2;

    //field injection
    @Autowired
    @Qualifier("cricketCoach")
    private  Coach coach3;

    private Coach coach4;
    //Constructor Injection
    @Autowired
    DemoController(@Qualifier("swimCoach")Coach theCoach){
        coach1 = theCoach;
    }

    //Setter Injection
    @Autowired
    public void setCoach(@Qualifier("tennisCoach")Coach theCoach){
        coach2=theCoach;
    }


    // we are not using any Qualifer here , so it will take whichever component that has @primary Annotation
    @Autowired
    public void setCoach4(Coach theCoach){ coach4 = theCoach;
    }


    @GetMapping("/workout")
    public String WorkOut1(){
        return "Constructor: "+coach1.getWorkOut()+"<hr>"+ "Setter: "+coach2.getWorkOut()+"<hr>"+"Field: "+coach3.getWorkOut()+"<hr>"+"Primary : "+coach4.getWorkOut();
    }
    @GetMapping("/")
    public String homePage(){
        return "Home";
    }
}
