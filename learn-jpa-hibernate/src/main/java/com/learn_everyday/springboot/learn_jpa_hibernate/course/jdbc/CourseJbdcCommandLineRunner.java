package com.learn_everyday.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Whenever application startups we need to insert the data into the table.
// We use the below CommandLineRunner to do the same.

@Component
public class CourseJbdcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert();
	}

}
