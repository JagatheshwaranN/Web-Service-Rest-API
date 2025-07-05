package com.jaga.learn_rest_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Student {

	@Id
	private int id;

	private String name;

	private String subject;

}
