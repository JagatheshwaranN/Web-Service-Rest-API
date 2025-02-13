package com.learn_everyday.springboot.learn_jpa_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.learn_everyday.springboot.learn_jpa_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional // Needed to execute the queries using JPA
public class CourseJpaRepository {

	// @Autowired
	@PersistenceContext // Similar job as Autowired.
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
