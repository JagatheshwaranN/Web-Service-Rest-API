package com.learn_everyday.course_registration_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	private String courseId;

	private String courseName;

	private String trainer;

	private int durationInWeeks;

}
