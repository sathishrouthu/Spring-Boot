package com.sathish.restcrud.dao;

import com.sathish.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee>  theQuery = entityManager.createQuery("FROM Employee",Employee.class);

        // execute query and get results
        List<Employee> theEmployees = theQuery.getResultList();

        // return the results
        return theEmployees;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class,id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);
    }

}
