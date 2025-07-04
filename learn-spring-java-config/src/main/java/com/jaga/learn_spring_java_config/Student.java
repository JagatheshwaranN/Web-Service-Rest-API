package com.jaga.learn_spring_java_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {

	private Writer writer;

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public Student() {
		System.out.println("Student Created...");
	}

	@Autowired
	public Student(@Qualifier("pen") Writer writer) {
		this.writer = writer;
	}

	public void writeExam() {
		writer.write();
	}
}
