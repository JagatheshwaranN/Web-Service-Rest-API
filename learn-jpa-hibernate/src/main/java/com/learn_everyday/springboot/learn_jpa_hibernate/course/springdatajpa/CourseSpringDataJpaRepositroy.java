package com.learn_everyday.springboot.learn_jpa_hibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn_everyday.springboot.learn_jpa_hibernate.course.Course;

public interface CourseSpringDataJpaRepositroy extends JpaRepository<Course, Long>{

}
