package com.learn_everyday.springboot.learn_jpa_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn_everyday.springboot.learn_jpa_hibernate.course.springdatajpa.CourseSpringDataJpaRepositroy;

// Whenever application startups we need to insert the data into the table.
// We use the below CommandLineRunner to do the same.

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository courseRepository;
	
//	@Autowired
//	private CourseJpaRepository courseRepository;
	
	@Autowired
	private CourseSpringDataJpaRepositroy courseRepository;
	

	@Override
	public void run(String... args) throws Exception {
		// For JDBC and JPA
//		courseRepository.insert(new Course(1, "Java Programming", "John Doe"));
//		courseRepository.insert(new Course(2, "Web Development", "Jane Smith"));
//		courseRepository.insert(new Course(3, "Data Structures", "Alice Johnson"));
		
		courseRepository.save(new Course(1, "Java Programming", "John Doe"));
		courseRepository.save(new Course(2, "Web Development", "Jane Smith"));
		courseRepository.save(new Course(3, "Data Structures", "Alice Johnson"));
		courseRepository.deleteById(3l);
		System.out.println(courseRepository.findById(1l));
		System.out.println(courseRepository.findById(2l));
		
		System.out.println(courseRepository.findAll());
		System.out.println(courseRepository.count());
		
		System.out.println(courseRepository.findByAuthor("Jane Smith"));
		System.out.println(courseRepository.findByName("Java Programming"));
	}

}
