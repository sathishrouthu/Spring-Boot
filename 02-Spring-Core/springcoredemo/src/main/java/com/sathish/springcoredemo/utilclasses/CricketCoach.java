package com.sathish.springcoredemo.utilclasses;

import com.sathish.springcoredemo.utilInterfaces.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {
    @PostConstruct
    public void doMyStuff(){
        System.out.println("Been is Constructed just Now...!!!! Doing Some Stuff" );
    }
    @Override
    public String getWorkOut(){
        return "Practice Bowling and Batting for 2 hours";
    }

    @PreDestroy
    public void cleanSomeStuff(){
        System.out.println("Cleaning..............................");
    }
}
