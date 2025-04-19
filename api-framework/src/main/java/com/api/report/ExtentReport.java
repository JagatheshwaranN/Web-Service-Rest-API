package com.api.report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	private static ExtentReports extentReports;
//	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
	private static final Map<ITestResult, ExtentTest> testMap = new ConcurrentHashMap<>();

	public static void setTest(ITestResult result, ExtentTest test) {
		extentTestThreadLocal.set(test);
		testMap.put(result, test);
	}

	public static ExtentTest getTest() {
		return extentTestThreadLocal.get();
	}

	public static ExtentTest getTest(ITestResult result) {
		return testMap.get(result);
	}

	public synchronized static ExtentReports getInstance() {
		if (extentReports == null) {
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

//	public static void setTest(ExtentTest test) {
//		ExtentReport.extentTest.set(test);
//	}
//
//	public static ExtentTest getTest() {
//		if (extentTest.get() == null) {
//			System.out.println("ExtentTest is NULL");
//		}
//		return extentTest.get();
//	}
//
	public static void removeTest() {
		extentTestThreadLocal.remove();
	}
}
