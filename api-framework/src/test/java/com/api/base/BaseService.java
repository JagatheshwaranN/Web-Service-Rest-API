package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filter.LogFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URI = "http://localhost:3000";
	private RequestSpecification requestSpecification;

	static {
		RestAssured.filters(new LogFilter());
	}

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URI);
	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
}
