package com.sathish.springcoredemo.utilclasses;

import com.sathish.springcoredemo.utilInterfaces.Coach;

public class SwimCoach implements Coach {
    public String getWorkOut(){
        return "Practice Swimming for 10 mins";
    }
}
