package com.learn_everyday.springboot.learn_jpa_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn_everyday.springboot.learn_jpa_hibernate.course.Course;

public interface CourseSpringDataJpaRepositroy extends JpaRepository<Course, Long> {
	
	// Custom method
	public List<Course> findByAuthor(String author);
	public List<Course> findByName(String name);
}
