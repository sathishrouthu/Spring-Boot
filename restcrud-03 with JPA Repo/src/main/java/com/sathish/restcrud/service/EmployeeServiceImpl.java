package com.sathish.restcrud.service;

import com.sathish.restcrud.dao.EmployeeRepository;
import com.sathish.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isEmpty())
            return null;
        else
            return result.get();
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = employeeRepository.save(theEmployee);
        return dbEmployee;
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

}
