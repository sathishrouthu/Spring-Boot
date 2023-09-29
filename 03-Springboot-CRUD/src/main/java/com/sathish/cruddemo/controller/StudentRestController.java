package com.sathish.cruddemo.controller;

import com.sathish.cruddemo.Entity.Student;
import com.sathish.cruddemo.dao.StudentDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentDAO studentDAO;
    @Autowired
    public StudentRestController(StudentDAO theStudentDAO){
        studentDAO = theStudentDAO;
    }
    @GetMapping("/students")
    public List<Student> getSudentsList(){
        return studentDAO.findAll();
    }

}
