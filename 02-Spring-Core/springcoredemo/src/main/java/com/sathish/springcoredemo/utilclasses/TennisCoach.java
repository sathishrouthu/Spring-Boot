package com.sathish.springcoredemo.utilclasses;

import com.sathish.springcoredemo.utilInterfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getWorkOut(){
        return "Practice Tennis for 3 hours";
    }
}
