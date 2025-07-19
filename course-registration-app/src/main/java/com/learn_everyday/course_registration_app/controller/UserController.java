package com.learn_everyday.course_registration_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn_everyday.course_registration_app.entity.CourseRegistry;
import com.learn_everyday.course_registration_app.entity.Users;
import com.learn_everyday.course_registration_app.service.CourseService;
import com.learn_everyday.course_registration_app.service.UserDetails;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = { "http://localhost:5500", "http://127.0.0.1:5500" })
public class UserController {

	@Autowired
	UserDetails userDetails;

	@Autowired
	CourseService courseService;

	@PostMapping("/add-user")
	public void addUser(@RequestBody Users user) {
		userDetails.addUser(user);
	}

	@GetMapping("/courses/enrolled")
	public List<CourseRegistry> getAvailableEnrolledCourseDetails() {
		return courseService.getEnrolledCourses();
	}

}
