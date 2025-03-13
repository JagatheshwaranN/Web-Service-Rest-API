package com.learn_everyday.learn_jpa.spring_jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn_everyday.learn_jpa.spring_jpa.entity.Person;
import com.learn_everyday.learn_jpa.spring_jpa.jpa.PersonJpaRepository;


@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User 10001 is -> {}", personJpaRepository.findPersonbyId(10001));
		logger.info("Insert -> {}", personJpaRepository.insertPerson(new Person("Rekha", "Chennai", new Date())));
		logger.info("Update 10002 -> {}", personJpaRepository.updatePerson(new Person(10002, "Sathya", "Coimbatore", new Date())));
		personJpaRepository.deletePersonbyId(10003);
		logger.info("All Users -> {}", personJpaRepository.findAllPersons());
	}

}
