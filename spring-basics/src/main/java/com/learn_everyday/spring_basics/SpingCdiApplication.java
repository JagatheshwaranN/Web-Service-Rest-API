package com.learn_everyday.spring_basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learn_everyday.spring_basics.cdi.CdiBusiness;

@SpringBootApplication
public class SpingCdiApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpingCdiApplication.class);

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpingCdiApplication.class, args);

		CdiBusiness cdiBusiness = context.getBean(CdiBusiness.class);
		LOGGER.info("{}", cdiBusiness);
		LOGGER.info("{}", cdiBusiness.getCdiDao());
	}

}
