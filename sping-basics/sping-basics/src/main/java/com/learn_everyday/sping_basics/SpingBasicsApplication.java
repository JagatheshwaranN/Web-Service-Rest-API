package com.learn_everyday.sping_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpingBasicsApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SpingBasicsApplication.class, args);
		BinarySearchImpl binarySearchImpl = context.getBean(BinarySearchImpl.class);
		System.out.println(binarySearchImpl.binarySearch(new int[] {12, 0, 3, 4}, 4));
	}

}
