package com.sathish.restcrud.rest;

import com.sathish.restcrud.entity.Employee;
import com.sathish.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/")
    public String home(){
        return "Home";
    }

    // end point "/employees" => return a list of students
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    // endpoint "/employees/id" => return employee by given id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee =  employeeService.findById(employeeId);
        if(theEmployee==null) {
            throw new EmployeeNotFoundException("Employee Id Not Found - "+employeeId);
        }
        return theEmployee;
    }

    // endpoint post "/employees" => add new employee to the db
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // this end point is for only adding employee, they cannot update through this,
        // if they pass an id through request then this will update instead of adding
        // so to make sure that the update not happen set id to 0
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // end point to delete "/employees
    @DeleteMapping("/employees/{employeeId}")
    public String deleteByiD(@PathVariable int employeeId){
        Employee deleteEmployee = employeeService.findById(employeeId);
        if(deleteEmployee==null){
            throw new EmployeeNotFoundException("Employee Id Not Found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee with id : "+employeeId+" has been Deleted";
    }

}
