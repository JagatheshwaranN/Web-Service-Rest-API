package com.api.models.request;

import java.util.List;

public class Student {

	private String name;
	private String location;
	private String phone;
	private List<String> courses;

	public Student(String name, String location, String phone, List<String> courses) {
		super();
		this.name = name;
		this.location = location;
		this.phone = phone;
		this.courses = courses;
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
