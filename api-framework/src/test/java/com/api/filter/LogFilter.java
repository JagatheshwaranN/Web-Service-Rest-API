package com.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		logger.info("Base URI: " + requestSpecification.getBaseUri());
		logger.info("Request Header: " + requestSpecification.getHeaders());
		logger.info("Request Payload: " + requestSpecification.getBody());
	}

	public void logResponse(Response response) {
		logger.info("Status Code: " + response.getStatusCode());
		logger.info("Response Header: " + response.getHeaders());
		logger.info("Response: " + response.getBody().asPrettyString());
	}
	
}
