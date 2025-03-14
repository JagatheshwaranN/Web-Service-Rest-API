package com.learn_everyday.learn_spring_data_jpa.spring_data_jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn_everyday.learn_spring_data_jpa.spring_data_jpa.entity.Person;
import com.learn_everyday.learn_spring_data_jpa.spring_data_jpa.jpa.PersonSpringDataJpaRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User 10001 is -> {}", personJpaRepository.findById(10001));
		logger.info("Insert -> {}", personJpaRepository.save(new Person("Rekha", "Chennai", new Date())));
		logger.info("Update 10002 -> {}",
				personJpaRepository.save(new Person(10002, "Sathya", "Coimbatore", new Date())));
		personJpaRepository.deleteById(10003);
		logger.info("All Users -> {}", personJpaRepository.findAll());
	}
	
}
