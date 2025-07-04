package com.jaga.learn_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		// Student student = context.getBean(Student.class);
		Student student = (Student) context.getBean("student1");
		student.writeExam();
		Teacher teacher = (Teacher) context.getBean("teacher");
		System.out.println(teacher.getAge());
		System.out.println(teacher.getName());
		teacher.wrote();
	}

}
