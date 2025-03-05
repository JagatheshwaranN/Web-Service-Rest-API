package com.api.control;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		TestNG testNG = new TestNG();
		List<String> suites = new ArrayList<>();
		suites.add("src/test/resources/runner/suite.xml");
		testNG.setTestSuites(suites);
		testNG.run();
	}

}
