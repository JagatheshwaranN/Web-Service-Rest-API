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

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReport.getInstance();
		logger.info("{} is Started!!", context.getCurrentXmlTest().getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("{} is Finished!!", context.getCurrentXmlTest().getName());
		ExtentReport.removeTest();
		extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getTestClass().getName() + " :: " + result.getMethod().getMethodName();
		ExtentTest test = extentReports.createTest(testName);
		ExtentReport.setTest(result, test);
		test.info(result.getMethod().getMethodName() + " Test is Started!!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("{} Test is Passed!!", result.getName());
		ExtentReport.getTest(result).pass(result.getMethod().getMethodName() + " Test is Passed!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("{} Test is Failed!!", result.getName());
		extentTest.log(Status.FAIL, result.getName() + " Test is Failed!!");
		ExtentReport.getTest(result).fail(result.getMethod().getMethodName() + " Test is Failed!!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("{} Test is Skipped!! - " + result.getName());
		ExtentReport.getTest(result).skip(result.getMethod().getMethodName() + " Test is Skipped!!");
	}

}
