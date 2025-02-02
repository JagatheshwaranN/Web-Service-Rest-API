package com.learn_everyday.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(new Course(1, "Learn Web Service", "Nate"), new Course(2, "Learn Rest API", "Jordan"), new Course(3, "Learn Spring", "Elisa"));
	}
}
