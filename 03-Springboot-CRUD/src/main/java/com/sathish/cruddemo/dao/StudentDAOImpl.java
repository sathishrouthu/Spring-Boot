package com.sathish.cruddemo.dao;

import com.sathish.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        List<Student> students = theQuery.getResultList();
        return students;
    }
    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData","Routhu");
        List<Student> students = theQuery.getResultList();
        return students;
    }
    @Override
    @Transactional
    public void updateStudent(Student student){
        entityManager.merge(student);
    }
    @Override
    @Transactional
    public void deleteStudent(int id){
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public int deleteAllStudents(){
        int numRowsEffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsEffected;
    }

}
