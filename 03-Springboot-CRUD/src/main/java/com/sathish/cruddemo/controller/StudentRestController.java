package com.sathish.cruddemo.controller;

import com.sathish.cruddemo.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents = new ArrayList<Student>();
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima", "Patel","sathish@gmail.com"));
        theStudents.add(new Student("Mario", "Rossi","sathish@gmail.com"));
        theStudents.add(new Student("Mary", "Smith","sathish@gmail.com"));
    }
    @GetMapping("/students")
    public List<Student> getSudentsList(){
        return theStudents;
    }

    @PostMapping("/students")
    public String addStudent(Student student){
        theStudents.add(student);
        return "Student Added";
    }

}
