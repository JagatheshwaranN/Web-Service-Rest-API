package com.learn_everyday.learn_soap.soap_course_management.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learn_everyday.learn_soap.soap_course_management.soap.bean.Course;

@Component
public class CourseDetailsService {
	
	private static List<Course> courses = new ArrayList<>();
	
	static {
		Course course1 = new Course(1, "Spring", "Learn about Spring Concepts");
		courses.add(course1);
		Course course2 = new Course(2, "Spring MVC", "Learn about Spring MVC Concepts");
		courses.add(course2);
		Course course3 = new Course(3, "Spring Boot", "Learn about Spring Boot Concepts");
		courses.add(course3);
		Course course4 = new Course(4, "Spring WebFlux", "Learn about Spring WebFlux Concepts");
		courses.add(course4);
	}
	
	// Course - 1
	// Course findById(int id)
	public Course findById(int id) {
		for(Course course : courses) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	// Courses
	//List<Course> findAll()
	public List<Course> findAll() {
		return courses;
	}
	
	// DeleteCourse
	// Course deleteById(int id)
	public int deleteById(int id) {
		// If we use For Each loop and delete the item, there might be chance of ConcurrentModificationException.
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == id) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}
	 
	// Update Course
	// New Course

}
