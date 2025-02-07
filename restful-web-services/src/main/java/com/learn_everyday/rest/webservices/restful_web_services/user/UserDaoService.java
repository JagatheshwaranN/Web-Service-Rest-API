package com.learn_everyday.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	// JPA/Hibernate > Database - Final Goal

	// UserDaoService > Static List - For now

	// public List<User> findAll()

	// public User save(user)

	// public User findOne(int id)

	private static List<User> users = new ArrayList<>();

	private static int userCount = 0;
	static {
		users.add(new User(generateId(), "John", LocalDate.now().minusYears(30)));
		users.add(new User(generateId(), "Alex", LocalDate.now().minusYears(27)));
		users.add(new User(generateId(), "Emi", LocalDate.now().minusYears(25)));
	}

	private static int generateId() {
		return ++userCount;
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User saveUser(User user) {
		user.setId(generateId());
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		
	}

}
