package com.api.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.StudentService;
import com.api.models.request.StudentBuilder;

import io.restassured.response.Response;

@Listeners(com.api.listener.TestListener.class)
public class AddUserBuilderTest {

	@Test(description = "Verify Add Student Endpoint is working..")
	public void addUserTest() {
		List<String> courses = Arrays.asList("Science", "Commerce", "Accounts");
		StudentBuilder studentBuilder = new StudentBuilder.Builder().name("Larry Wilson").location("California")
				.phone("313-456-6768").courses(courses).build();

		StudentService service = new StudentService();
		Response response = service.addStudentBuilder(studentBuilder);
		com.api.models.response.Student reStudent = response.as(com.api.models.response.Student.class);
		System.out.println(reStudent.getId());
		System.out.println(reStudent.getName());
		System.out.println(reStudent.getLocation());
		System.out.println(reStudent.getPhone());
		System.out.println(reStudent.getCourses());
		Assert.assertTrue(reStudent.getId() != null);
		Assert.assertEquals(reStudent.getName(), studentBuilder.getName());
	}
	
}
