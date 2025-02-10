package com.learn_everyday.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// When a class talks to DB in spring, it should be annotated with Repository annotation.

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String INSERT_QUERY  = 
			"""
			INSERT INTO course (id, name, author) VALUES (1, 'Java Programming', 'John Doe');
			""";
	
	public void insert() {
		jdbcTemplate.update(INSERT_QUERY);
	}

}
