package com.learn_everyday.course_registration_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CourseRegistry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String emailId;

	private String courseName;

	public CourseRegistry() {

	}

	public CourseRegistry(String name, String emailId, String courseName) {
		this.name = name;
		this.emailId = emailId;
		this.courseName = courseName;
	}

}
