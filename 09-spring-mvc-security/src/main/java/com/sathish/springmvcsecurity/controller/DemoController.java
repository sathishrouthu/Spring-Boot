package com.sathish.springmvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/meetings")
    public String showMeetings(){
        return "meetings-page";
    }
    @GetMapping("/systems")
    public String showSystems(){
        return "systems-page";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
