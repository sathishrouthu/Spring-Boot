package com.sathish.cruddemo.dao;

import com.sathish.cruddemo.Entity.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public Student findBYId(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);
}
