package com.jaga.learn_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.readStudents();
		if (students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		Student student = studentService.readStudentById(id);
		if (student == null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping("/students")
	public ResponseEntity<String> postStudent(@RequestBody Student student) {
		String message = studentService.createStudent(student);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<String> putStudent(@RequestBody Student student) {
		String message = studentService.updateStudent(student);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		String message = studentService.deleteStudent(id);
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/students")
	public ResponseEntity<String> deleteStudents() {
		String message = studentService.deleteStudents();
		return new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/students/subject/{subject}")
	public ResponseEntity<List<Student>> getStudents(@PathVariable("subject") String subject) {
		List<Student> students = studentService.readStudentBySubject(subject);
		if (students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@PostMapping("/students/filter")
	public ResponseEntity<List<Student>> getStudents(@Param("gender") String gender, @Param("subject") String subject) {
		List<Student> students = studentService.readStudentByGenderAndSubject(gender, subject);
		if (students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

}
