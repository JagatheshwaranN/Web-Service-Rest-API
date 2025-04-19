package com.api.constants;

public enum TestConstant {

	BASE_URI("http://localhost:3000"), BASE_PATH("/students");

	private String value;

	TestConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
