package com.learn_everyday.course_registration_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn_everyday.course_registration_app.entity.CourseRegistry;

@Repository
public interface CourseRegistryRepository extends JpaRepository<CourseRegistry, Integer> {

}
