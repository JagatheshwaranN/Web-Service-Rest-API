package com.jaga.learn_spring;

import lombok.Getter;

public class Teacher {

	@Getter
	private int age;

	@Getter
	private String name;

	private Writer writer;

	public Teacher() {

	}

	public Teacher(int age, String name, Writer writer) {
		super();
		this.age = age;
		this.name = name;
		this.writer = writer;
	}

	public void wrote() {
		writer.write();
	}

}
