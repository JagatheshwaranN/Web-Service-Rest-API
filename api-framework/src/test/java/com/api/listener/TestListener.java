package com.api.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.api.report.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

	public ExtentReports extentReports;
	public ExtentTest extentTest;

	public void onStart(ITestContext context) {
		extentReports = ExtentReport.getInstance();
		logger.info("Test Suite Started!!");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished!!");
		extentReports.flush();
	}

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		ExtentReport.setTest(extentTest);
		logger.info("Test Started!! - " + result.getMethod().getMethodName());
		logger.info("Description!! - " + result.getMethod().getDescription());
		extentTest.log(Status.INFO, "Test Started!! - " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed!! - " + result.getMethod().getMethodName());
		extentTest.log(Status.INFO, "Test Passed!! - " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Test Failed!! - " + result.getMethod().getMethodName());
		extentTest.log(Status.INFO, "Test Failed!! - " + result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped!! - " + result.getMethod().getMethodName());
		extentTest.log(Status.INFO, "Test Skipped!! - " + result.getMethod().getMethodName());
	}

}
