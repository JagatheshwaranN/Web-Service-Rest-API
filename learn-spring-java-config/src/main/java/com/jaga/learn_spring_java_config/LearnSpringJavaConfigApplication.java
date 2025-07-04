package com.jaga.learn_spring_java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaga.learn_spring_java_config.setup.MyConfiguration;

public class LearnSpringJavaConfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

		// Approach 1
		// Student student1 = context.getBean(Student.class);

		// Approach 2
		// Student student2 = (Student) context.getBean("student");

		// Approach 3
		Student student3 = context.getBean(Student.class);
		student3.writeExam();
	}

}
