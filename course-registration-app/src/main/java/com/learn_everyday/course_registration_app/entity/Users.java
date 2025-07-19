package com.learn_everyday.course_registration_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {

	@Id
	private int id;

	private String username;

	private String password;

	private String role;

}
