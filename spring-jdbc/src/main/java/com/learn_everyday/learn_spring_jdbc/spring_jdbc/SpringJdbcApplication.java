package com.learn_everyday.learn_spring_jdbc.spring_jdbc;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn_everyday.learn_spring_jdbc.spring_jdbc.jdbc.Person;
import com.learn_everyday.learn_spring_jdbc.spring_jdbc.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}", personJdbcDao.findAllPerson());
		logger.info("User 10001 is -> {}", personJdbcDao.findPersonbyId(10001));
		logger.info("Delete User 10003 & No of rows affected -> {}", personJdbcDao.deletePersonbyId(10003));
		logger.info("Insert User 10004 & No of rows affected -> {}", personJdbcDao.insertPerson(new Person(10004, "Rekha", "Chennai", new Date())));
		logger.info("Update User 10002 & No of rows affected -> {}", personJdbcDao.updatePerson(new Person(10002, "Sathya", "Coimbatore", new Date())));
	}
	
}
