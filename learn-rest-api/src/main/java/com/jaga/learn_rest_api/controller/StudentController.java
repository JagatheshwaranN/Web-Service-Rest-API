package com.jaga.learn_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaga.learn_rest_api.model.Student;
import com.jaga.learn_rest_api.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.fetchStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentService.fetchStudentById(id);
	}

	@PostMapping("/students")
	public String postStudent(Student student) {
		return studentService.addStudent(student);
	}

	@PutMapping("/students/{id}")
	public String putStudent(Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}
}
