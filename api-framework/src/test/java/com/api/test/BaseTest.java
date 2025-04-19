package com.api.test;

import org.testng.annotations.AfterMethod;

import com.api.resources.StudentService;

public class BaseTest {

	protected StudentService service = new StudentService();

	@AfterMethod
	public void tearDown() {
		service.clearRequestSpecification();
	}

}
