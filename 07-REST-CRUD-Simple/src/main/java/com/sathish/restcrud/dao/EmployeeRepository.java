package com.sathish.restcrud.dao;

import com.sathish.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path="mypathname")    ==>  for adding your custom path other than plural path provided by spring data rest
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
