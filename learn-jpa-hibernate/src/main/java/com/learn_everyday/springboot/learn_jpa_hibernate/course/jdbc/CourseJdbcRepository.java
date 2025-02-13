package com.learn_everyday.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn_everyday.springboot.learn_jpa_hibernate.course.Course;

// When a class talks to DB in spring, it should be annotated with Repository annotation.

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unused")
	private static String INSERT_QUERY = """
			INSERT INTO course (id, name, author) VALUES (1, 'Java Programming', 'John Doe');
			""";

	private static String DYNAMIC_INSERT_QUERY = """
			INSERT INTO course (id, name, author) VALUES (?, ?, ?);
			""";

	private static String DYNAMIC_DELETE_QUERY = """
			DELETE FROM course where id = ?;
			""";

	private static String DYNAMIC_SELECT_QUERY = """
			SELECT * FROM course where id = ?;
			""";

	public void insert(Course course) {
		jdbcTemplate.update(DYNAMIC_INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		jdbcTemplate.update(DYNAMIC_DELETE_QUERY, id);
	}

	public Course findById(long id) {
		// IMPORTANT - For this functionality to work properly, we should have the
		// variable names of Bean class
		// and Database as same.
		// Here, we need to map the resultset to corresponding bean class.
		// For that, we use BeanPropertyRowMapper class.
		return jdbcTemplate.queryForObject(DYNAMIC_SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
