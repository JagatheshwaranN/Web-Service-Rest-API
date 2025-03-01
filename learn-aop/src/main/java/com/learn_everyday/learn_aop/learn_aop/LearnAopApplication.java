package com.learn_everyday.learn_aop.learn_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn_everyday.learn_aop.learn_aop.business.Business1;
import com.learn_everyday.learn_aop.learn_aop.business.Business2;

@SpringBootApplication
public class LearnAopApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Business1 business1;
	
	@Autowired
	Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(LearnAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.processData());
		logger.info(business2.processData());
	}

}
