package com.sathish.cruddemo;
import java.util.*;
import com.sathish.cruddemo.Entity.Student;
import com.sathish.cruddemo.dao.StudentDAO;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{

			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			//  queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			//  updateStudent(studentDAO);

			//  deleteStudent(studentDAO);

			//  deleteAllStudents

		};
	}
	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new Student");
		Student student = new Student("Sathish","Routhu","sathishrouthu222@gmail.com");
		studentDAO.save(student);
		System.out.println("new Student Saved");
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
		Student student = studentDAO.findBYId(id);
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
}
