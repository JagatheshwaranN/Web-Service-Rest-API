package com.api.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.Student;

import io.restassured.response.Response;

public class UpdateUserTest extends BaseTest {

	@Test
	public void updateUserTest1() {
		List<String> courses = Arrays.asList("Science", "Commerce", "Accounts");
		Student student = new Student("Thread1 User", "New York", "312-345-5677", courses);
		Response response = service.updateStudent(student, "0cde");
		com.api.models.response.Student reStudent = response.as(com.api.models.response.Student.class);
		System.out.println(reStudent.getId());
		System.out.println(reStudent.getName());
		System.out.println(reStudent.getLocation());
		System.out.println(reStudent.getPhone());
		System.out.println(reStudent.getCourses());
		Assert.assertTrue(reStudent.getId() != null);
		Assert.assertEquals(reStudent.getName(), student.getName());
	}

}
