package com.jaga.learn_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaga.learn_rest_api.entity.Student;
import com.jaga.learn_rest_api.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> readStudents() {
		return studentRepository.findAll();
	}

	public Student readStudentById(int id) {
		return studentRepository.findById(id).orElse(new Student(0, null, null));
	}

	public String createStudent(Student student) {
		studentRepository.save(student);
		return "Student added.";
	}

	public String updateStudent(Student student) {
		studentRepository.save(student);
		return "Student updated.";
	}

	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student deleted.";
	}

	public String deleteStudents() {
		studentRepository.deleteAll();
		return "All Students deleted.";
	}

}
