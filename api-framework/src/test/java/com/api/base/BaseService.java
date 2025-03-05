package com.api.base;

import com.api.filter.LogFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URI = "http://localhost:3000";
	
	RequestSpecification requestSpecification;
	
	// Base URI updated for GitHub Actions
	// private static final String BASE_URI = "https://57ce-27-5-200-251.ngrok-free.app";
	
//	private static final ThreadLocal<RequestSpecification> requestSpecification = new ThreadLocal<RequestSpecification>(); 

	static {
		RestAssured.filters(new LogFilter());
	}

	public BaseService() {
		// getRequestSpecification();
		requestSpecification = RestAssured.given().baseUri(BASE_URI);
	}
	
//	protected RequestSpecification getRequestSpecification() {
//		RequestSpecification spec = requestSpecification.get();
//		if(spec == null) {
//			spec = initRequestSpecification();
//			requestSpecification.set(spec);
//		}
//		return spec;
//	}

//	private RequestSpecification initRequestSpecification() {
//		return RestAssured.given().baseUri(BASE_URI);
//	}
//
//	protected void clearRequestSpecification() {
//	    requestSpecification.remove();
//	}

	protected Response postRequest(Object payload, String endpoint) {
//		return getRequestSpecification().contentType(ContentType.JSON).body(payload).post(endpoint);
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response getRequest(String param, String endpoint) {
//		return getRequestSpecification().pathParam("studentId", param).get(endpoint + "/{studentId}");
		return requestSpecification.pathParam("studentId", param).get(endpoint + "/{studentId}");
	}
	
//	@AfterMethod
//	public void tearDown() {
//		clearRequestSpecification();
//	}
	
}
