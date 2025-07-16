package com.learn_everyday.spring_security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn_everyday.spring_security.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	List<Student> studentList = new ArrayList<>(
			Arrays.asList(new Student(101, "John", "AI"), new Student(102, "Alex", "BC")));

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentList;
	}

	@PostMapping("/admin/students")
	public void addStudent(@RequestBody Student student) {
		studentList.add(student);
	}

	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

}
