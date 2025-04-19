package com.api.filter;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.report.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LogFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LogFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpecification) {
		ExtentTest test = ExtentReport.getTest();
		if (test == null) {
			logger.warn("ExtentTest is NULL for thread: {}", Thread.currentThread().getName());
			return;
		}
		logger.info("Base URI:  {}", requestSpecification.getBaseUri());
		test.log(Status.INFO, "BASE URI: " + requestSpecification.getBaseUri());

		logger.info("Request Headers: {}", requestSpecification.getHeaders());
		test.log(Status.INFO, "Request Headers: " + requestSpecification.getHeaders().toString());

		logger.info("Request Payload: {}", Optional.ofNullable(requestSpecification.getBody()));
		test.log(Status.INFO, "Request Payload: " + Optional.ofNullable(requestSpecification.getBody()));
	}

	public void logResponse(Response response) {
		ExtentTest test = ExtentReport.getTest();
		if (test == null) {
			logger.warn("ExtentTest is NULL for thread: {}", Thread.currentThread().getName());
			return;
		}
		logger.info("Status Code: {}", response.getStatusCode());
		test.log(Status.INFO, "Response Status: " + response.getStatusCode());

		logger.info("Response Headers: {}", response.getHeaders());
		test.log(Status.INFO, "Response Headers: " + response.getHeaders().toString());

		logger.info("Response Body: {}", response.getBody().asPrettyString());
		test.log(Status.INFO, "Response Body: " + response.getBody().asPrettyString());
	}

}
