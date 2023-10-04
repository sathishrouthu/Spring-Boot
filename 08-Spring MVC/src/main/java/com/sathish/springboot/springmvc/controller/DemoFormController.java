package com.sathish.springboot.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoFormController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "form-page";
    }


    @RequestMapping("/processForm")
    public String processForm(){
        return "hello";
    }


    // Using HttpServlet Request
    @RequestMapping("/processForm2")
    public String processForm2(HttpServletRequest request, Model model){
        String theName = request.getParameter("name");
        theName= theName.toUpperCase();
        String result  = "Hi "+theName+" --- processForm 2";
        model.addAttribute("message",result);
        return "hello2";
    }


    // Using @RequestParam
    @RequestMapping("/processForm3")
    public String processForm3(@RequestParam("name") String name,Model model){
        name = name.toUpperCase();
        String result  = "Hi "+name+" --- processForm 3";
        model.addAttribute("message",result);
        return "hello3";
    }

    @RequestMapping(value = "/processForm4",method = RequestMethod.POST)
    public String processForm4(@RequestParam("name") String name,Model model){
        name = name.toUpperCase();
        String result  = "Hi "+name+" --- processForm 3";
        model.addAttribute("message",result);
        return "hello3";
    }


}
