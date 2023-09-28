package com.sathish.cruddemo.dao;

import com.sathish.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void updateStudent(Student student);

    public void deleteStudent(int id);

    public int deleteAllStudents();
}
