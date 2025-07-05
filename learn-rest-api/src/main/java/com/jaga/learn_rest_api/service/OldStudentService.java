package com.jaga.learn_rest_api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jaga.learn_rest_api.entity.Student;

@Service
public class OldStudentService {

	List<Student> studentList = Arrays.asList(new Student(101, "Alex", "Male", "java"),
			new Student(102, "John", "Male", "spring"));

	public List<Student> fetchStudents() {
		return studentList;
	}

	public Student fetchStudentById(int id) {
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				index = i;
				flag = true;
				break;
			}
		}
		if (flag) {
			return studentList.get(index);
		} else {
			return new Student(0, null, null, null);
		}
	}

	public String addStudent(Student student) {
		studentList.add(student);
		return "Student added.";
	}

	public String updateStudent(Student student) {
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == student.getId()) {
				index = i;
				flag = true;
				break;
			}
		}
		if (flag) {
			studentList.set(index, student);
			return "Student updated.";
		} else {
			return "Student not exists.";
		}
	}

	public String deleteStudent(int id) {
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				index = i;
				flag = true;
				break;
			}
		}
		if (flag) {
			studentList.remove(index);
			return "Student deleted.";
		} else {
			return "Student not exists.";
		}
	}

}
