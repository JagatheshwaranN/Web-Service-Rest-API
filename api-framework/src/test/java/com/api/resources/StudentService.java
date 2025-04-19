package com.api.resources;

import com.api.base.BaseService;
import com.api.constants.TestConstant;
import com.api.models.request.Student;
import com.api.models.request.StudentBuilder;

import io.restassured.response.Response;

public class StudentService extends BaseService {

	public Response addStudent(Student payload) {
		return post(TestConstant.BASE_PATH.getValue(), payload);
	}

	public Response addStudentBuilder(StudentBuilder payload) {
		return post(TestConstant.BASE_PATH.getValue(), payload);
	}

	public Response getStudent(String id) {
		return get(TestConstant.BASE_PATH.getValue(), id);
	}

	public Response updateStudent(Student payload, String id) {
		return put(TestConstant.BASE_PATH.getValue(), payload, id);
	}

	public Response deleteStudent(String id) {
		return delete(TestConstant.BASE_PATH.getValue(), id);
	}

}
