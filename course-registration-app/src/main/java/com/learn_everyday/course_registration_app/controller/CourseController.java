package com.learn_everyday.course_registration_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn_everyday.course_registration_app.entity.Course;
import com.learn_everyday.course_registration_app.service.CourseService;

@RestController
@CrossOrigin(origins = { "http://localhost:5500", "http://127.0.0.1:5500" })
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("courses")
	public List<Course> getAvailableCourseDetails() {
		return courseService.getCourses();
	}

//	@GetMapping("courses/enrolled")
//	public List<CourseRegistry> getAvailableEnrolledCourseDetails() {
//		return courseService.getEnrolledCourses();
//	}

	@PostMapping("courses/register")
	public Map<String, String> registerToCourse(@RequestParam("name") String name,
			@RequestParam("emailId") String emailId, @RequestParam("courseName") String courseName) {
		courseService.enrollToCourse(name, emailId, courseName);
		String message = String.format("Congratulations! %s, you have successfully registered for %s course.", name,
				courseName);
		return Map.of("message", message);
	}

	@GetMapping("health")
	public String checkHealth() {
		return "Application is up and running.";
	}

}
