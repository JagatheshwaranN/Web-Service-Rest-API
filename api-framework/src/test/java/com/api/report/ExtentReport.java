package com.api.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	public static ExtentReports getInstance() {
		if(extentReports == null) {
			return createInstance("test-output/report/extent.html");
		} else {
			return extentReports;
		}
	}

	private static ExtentReports createInstance(String filePath) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Student Service Report");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		return extentReports;
	}
	
	public static void setTest(ExtentTest test) {
		extentTest = test;
	}
	
	public static ExtentTest getTest() {
		return extentTest;
	}
	
}
