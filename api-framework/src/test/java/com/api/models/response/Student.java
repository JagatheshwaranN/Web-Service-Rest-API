package com.api.models.response;

import java.util.List;

public class Student {

	private String id;
	private String name;
	private String location;
	private String phone;
	private List<String> courses;

	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getPhone() {
		return phone;
	}

	public List<String> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", location=" + location + ", phone=" + phone + ", courses=" + courses + "]";
	}

}
