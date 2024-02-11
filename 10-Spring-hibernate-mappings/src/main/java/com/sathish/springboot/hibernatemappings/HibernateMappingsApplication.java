package com.sathish.springboot.hibernatemappings;

import com.sathish.springboot.hibernatemappings.dao.AppDAO;
import com.sathish.springboot.hibernatemappings.entity.Mentor;
import com.sathish.springboot.hibernatemappings.entity.MentorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			createMentor(appDAO);
		};
	}
	public void createMentor(AppDAO appDAO){
		Mentor mentor = new Mentor("sathish","routhu","sathish@gmail.com");
		MentorDetails mentorDetails = new MentorDetails("https://youtube.com/sathishrouthu","cricket");
		mentor.setMentorDetails(mentorDetails);
		System.out.println("Saving Mentor: " + mentor);
		appDAO.save(mentor);
	}
}
