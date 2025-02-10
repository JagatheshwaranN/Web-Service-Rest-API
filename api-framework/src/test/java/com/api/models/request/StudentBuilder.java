package com.api.models.request;

import java.util.List;

public class StudentBuilder {

	private String name;
	private String location;
	private String phone;
	private List<String> courses;

	public StudentBuilder(String name, String location, String phone, List<String> courses) {
		super();
		this.name = name;
		this.location = location;
		this.phone = phone;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentBuilder [name=" + name + ", location=" + location + ", phone=" + phone + ", courses=" + courses
				+ "]";
	}

	public static class Builder {
		private String name;
		private String location;
		private String phone;
		private List<String> courses;

		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder location(String location) {
			this.location = location;
			return this;
		}
		
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public Builder courses(List<String> courses) {
			this.courses = courses;
			return this;
		}
		
		public StudentBuilder build() {
			StudentBuilder studentBuilder = new StudentBuilder(name, location, phone, courses);
			return studentBuilder;
		}
		
	}

}
