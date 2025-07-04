package com.jaga.learn_spring_boot_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {

	@Autowired
	@Qualifier("pencil")
	private Writer writer;

	public Student() {
		System.out.println("Student Created..");
	}

	public void writeExam() {
		writer.write();
	}

}
