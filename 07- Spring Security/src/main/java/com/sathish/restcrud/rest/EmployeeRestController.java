package com.sathish.restcrud.rest;

import com.sathish.restcrud.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private List<Employee> theEmployees;
    @PostConstruct
    private void loadData(){
        theEmployees = new ArrayList<>();
        theEmployees.add(new Employee(1,"sathish","routhu","sathishrouthu@gmail.com"));
        theEmployees.add(new Employee(2,"siva","dev","sivadev@gmail.com"));
        theEmployees.add(new Employee(3,"ravi","nam","ravi@gmail.com"));
        theEmployees.add(new Employee(4,"ajay","khan","ajay@gmail.com"));
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }
    // end point "/employees" => return a list of students

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return theEmployees;
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        if(employeeId < 0 || employeeId>=theEmployees.size()) throw new EmployeeNotFoundException("Employee id is invalid..!");
        return theEmployees.get(employeeId);
    }

    // Exception Handler for Index out of bound for employee
    /*
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // another generic exception handler
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

     */

}
