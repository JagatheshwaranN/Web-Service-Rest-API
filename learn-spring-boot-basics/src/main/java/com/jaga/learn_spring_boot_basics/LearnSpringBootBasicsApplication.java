package com.jaga.learn_spring_boot_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnSpringBootBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LearnSpringBootBasicsApplication.class, args);
		Student student1 = context.getBean(Student.class);
		student1.writeExam();
	}
}
