package com.learn_everyday.spring_basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn_everyday.spring_basics.xml.XmlUserDAO;

public class SpringXmlConfigApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringXmlConfigApplication.class);

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			LOGGER.info("Beans Loaded -> {}", (Object)context.getBeanDefinitionNames());
			XmlUserDAO userDAO1 = context.getBean(XmlUserDAO.class);
			LOGGER.info("{}", userDAO1);
			LOGGER.info("{}", userDAO1.getXmlJdbcConnection());
		}
	}
}
