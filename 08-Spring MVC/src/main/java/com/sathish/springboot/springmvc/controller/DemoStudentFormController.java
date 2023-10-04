package com.sathish.springboot.springmvc.controller;

import com.sathish.springboot.springmvc.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DemoStudentFormController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> favouriteSystems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model theModel){

        theModel.addAttribute("student",new Student());

        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("favouriteSystems",favouriteSystems);

        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        System.out.println("Student: " + theStudent.getFirstName() + "  " + theStudent.getLastName());
        return "student-confirmed";
    }
}
