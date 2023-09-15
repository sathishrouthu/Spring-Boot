package com.sathish.springcoredemo.config;

import com.sathish.springcoredemo.utilInterfaces.Coach;
import com.sathish.springcoredemo.utilclasses.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
