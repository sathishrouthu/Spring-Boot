package com.sathish.cruddemo;
import java.util.*;
import com.sathish.cruddemo.Entity.Student;
import com.sathish.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	/*
	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new Student");
		Student student = new Student("Sathish","Routhu","sathishrouthu222@gmail.com");
		studentDAO.save(student);
		System.out.println("new Student Saved");
	}
	private void deleteStudent(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		int studentId = students.get(0).getId();
		System.out.println(students);
		studentDAO.deleteStudent(studentId);
		System.out.println(studentDAO.findAll());
	}
	private void deleteAll(StudentDAO studentDAO){
		int numDeleted  = studentDAO.deleteAllStudents();
		System.out.println("No. of Students Deleted : " + numDeleted);
	}
	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating Studentss...");
		List<Student> students = new ArrayList<>();
		students.add(new Student("Sathish","Routhu","sathish@gmail.com"));
		students.add(new Student("rocky","Routhu","rocky@gmail.com"));
		students.add(new Student("ram","mygapula","ram@gmail.com"));
		students.add(new Student("santhosh","yetchina","santhosh@gmail.com"));
		for(int i=0;i<students.size();i++){
			studentDAO.save(students.get(i));
		}
		System.out.println("Saved  Studentss...");
	}
	private void readStudent(StudentDAO studentDAO){
		Student s = new Student("Sathish","Routhu","sathish@gmail.com");
		studentDAO.save(s);
		int id = s.getId();
		Student student = studentDAO.findById(id);
		System.out.println(student);
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		System.out.println(students);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> students = studentDAO.findByLastName("Routhu");
		System.out.println(students);
	}

	private void  updateStudent(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();
		int studentId  = students.get(1).getId();
		Student student = studentDAO.findById(studentId);
		System.out.println(student);
		student.setFirstName("Vamsi");
		studentDAO.updateStudent(student);
		student = studentDAO.findById(studentId);
		System.out.println(student);
	}
	*/
}
