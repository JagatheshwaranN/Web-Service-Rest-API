package com.jaga.learn_spring_java_config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pen implements Writer {

	public Pen() {
		System.out.println("Pen Created..");
	}

	@Override
	public void write() {
		System.out.println("Student write exams using Pen..");
	}
}
