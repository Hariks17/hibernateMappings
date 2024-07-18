package com.thehariks.hibernateMappings;

import com.thehariks.hibernateMappings.dao.AppDAO;
import com.thehariks.hibernateMappings.entity.Instructor;
import com.thehariks.hibernateMappings.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//			createConstructor(appDAO);

//			findInstructor(appDAO);

//		deleteInstructor(appDAO);

			findInstructorDetail(appDAO);
		};
	}

	private void findInstructorDetail(AppDAO appDAO) {

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(1);

		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 3;

		appDAO.delete(id);
	}

	private void findInstructor(AppDAO appDAO) {

		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Found Instructor "+instructor);
	}

	private void createConstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Hariharan","Sankar","hari@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("Amazing Studio","Badminton");

		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Instructor Object "+instructor);
		appDAO.save(instructor);
	}
}
