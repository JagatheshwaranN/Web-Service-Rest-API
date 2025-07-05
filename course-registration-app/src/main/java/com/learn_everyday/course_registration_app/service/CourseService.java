package com.learn_everyday.course_registration_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn_everyday.course_registration_app.entity.Course;
import com.learn_everyday.course_registration_app.entity.CourseRegistry;
import com.learn_everyday.course_registration_app.repository.CourseRegistryRepository;
import com.learn_everyday.course_registration_app.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseRegistryRepository courseRegistryRepository;

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	public List<CourseRegistry> getEnrolledCourses() {
		return courseRegistryRepository.findAll();
	}

	public CourseRegistry enrollToCourse(String name, String emailId, String courseName) {
		CourseRegistry registry = new CourseRegistry(name, emailId, courseName);
		return courseRegistryRepository.save(registry);
	}

}
