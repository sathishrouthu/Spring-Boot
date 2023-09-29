package com.sathish.restcrud.service;

import com.sathish.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
