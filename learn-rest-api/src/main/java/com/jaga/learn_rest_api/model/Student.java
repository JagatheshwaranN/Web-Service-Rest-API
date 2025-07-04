package com.jaga.learn_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

	private int id;
	private String name;
	private String subject;

}
