package com.api.test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.request.StudentBuilder;
import com.api.models.response.Student;
import com.api.resources.StudentService;

import io.restassured.response.Response;

@Listeners(com.api.listener.TestListener.class)
public class AddUserBuilderTest {

	@Test(description = "Verify Add Student Endpoint is working..")
	public void addUserTest() {
		List<String> courses = Arrays.asList("Science", "Commerce", "Accounts");
		StudentBuilder studentBuilder = new StudentBuilder.Builder().name("Nate Eaten").location("California")
				.phone("313-456-6768").courses(courses).build();

		StudentService service = new StudentService();
		Response response = service.addStudentBuilder(studentBuilder);
		System.out.println(service.addStudentBuilder(studentBuilder));
		Student reStudent = response.as(Student.class);
		System.out.println(reStudent.getId());
		System.out.println(reStudent.getName());
		System.out.println(reStudent.getLocation());
		System.out.println(reStudent.getPhone());
		System.out.println(reStudent.getCourses());
		Assert.assertTrue(reStudent.getId() != null);
		Assert.assertEquals(reStudent.getName(), studentBuilder.getName());
	}
	
}
