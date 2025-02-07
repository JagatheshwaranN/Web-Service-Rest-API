package com.learn_everyday.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;
	
	@Size(min = 2, message = "Name should atleast have 2 characters.")
	private String name;
	
	@Past(message = "DOB should be in the Past.")
	private LocalDate dob;

	public User(Integer id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
