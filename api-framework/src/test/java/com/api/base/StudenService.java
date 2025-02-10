package com.api.base;

import com.api.models.request.Student;
import com.api.models.request.StudentBuilder;

import io.restassured.response.Response;

public class StudenService extends BaseService {
	
	private static final String BASE_PATH = "/students";
	
	public Response addStudent(Student payload) {
		return postRequest(BASE_PATH, payload);
	}

	public Response addStudentBuilder(StudentBuilder payload) {
		return postRequest(BASE_PATH, payload);
	}

}
