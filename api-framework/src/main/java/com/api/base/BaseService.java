package com.api.base;

import com.api.filter.LogFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URI = "http://localhost:3000";

//	RequestSpecification requestSpecification;

	// Base URI updated for GitHub Actions
	// private static final String BASE_URI =
	// "https://57ce-27-5-200-251.ngrok-free.app";

	private static final ThreadLocal<RequestSpecification> requestSpecification = new ThreadLocal<RequestSpecification>();

//	static {
//		RestAssured.filters(new LogFilter());
//	}

	public BaseService() {
		getRequestSpecification();
	}

	protected RequestSpecification getRequestSpecification() {
		RequestSpecification spec = requestSpecification.get();
		if (spec == null) {
			spec = initRequestSpecification();
			requestSpecification.set(spec);
		}
		return spec;
	}

	private RequestSpecification initRequestSpecification() {
		return RestAssured.given().baseUri(BASE_URI).filter(new LogFilter());
	}

	public void clearRequestSpecification() {
		requestSpecification.remove();
	}

	protected Response post(String endpoint, Object payload) {
		return getRequestSpecification().contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response get(String endpoint, String param) {
		return getRequestSpecification().pathParam("studentId", param).get(endpoint + "/{studentId}");
	}

	protected Response put(String endpoint, Object payload, String param) {
		return getRequestSpecification().pathParam("studentId", param).contentType(ContentType.JSON).body(payload)
				.put(endpoint + "/{studentId}");
	}

	protected Response delete(String endpoint, String param) {
		return getRequestSpecification().pathParam("studentId", param).delete(endpoint + "/{studentId}");
	}

}
