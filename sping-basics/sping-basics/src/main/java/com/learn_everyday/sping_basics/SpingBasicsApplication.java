package com.learn_everyday.sping_basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpingBasicsApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(SpingBasicsApplication.class, args);
		
//		Default - singleton
//		When we request ApplicationContext for a Bean for 10 times. We will 
//		get the same bean, which is Singleton.

		BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch2 = context.getBean(BinarySearchImpl.class);
		System.out.println(binarySearch);
		System.out.println(binarySearch2);
		System.out.println(binarySearch.binarySearch(new int[] {12, 0, 3, 4}, 4));
	}

}
