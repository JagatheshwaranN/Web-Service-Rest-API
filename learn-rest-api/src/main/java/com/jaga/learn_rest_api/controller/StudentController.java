package com.jaga.learn_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaga.learn_rest_api.entity.Student;
import com.jaga.learn_rest_api.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.readStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentService.readStudentById(id);
	}

	@PostMapping("/students")
	public String postStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@PutMapping("/students/{id}")
	public String putStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}

	@DeleteMapping("/students")
	public void deleteStudents() {
		studentService.deleteStudents();
	}

}
