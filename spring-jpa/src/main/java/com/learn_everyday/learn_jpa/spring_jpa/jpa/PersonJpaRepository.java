package com.learn_everyday.learn_jpa.spring_jpa.jpa;

import org.springframework.stereotype.Repository;

import com.learn_everyday.learn_jpa.spring_jpa.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
		
	public Person findPersonbyId(int id) {
		return entityManager.find(Person.class, id);
	}

//	public int deletePersonbyId(int id) {
//		return jdbcTemplate.update("Delete from Person where id=?", new Object[] { id });
//	}
//
//	public int insertPerson(Person person) {
//		return jdbcTemplate.update("Insert into Person (id, name, location, birth_date) Values (?, ?, ?, ?)",
//				new Object[] { person.getId(), person.getName(), person.getLocation(),
//						new Timestamp(person.getBirth_date().getTime()) });
//	}
//
//	public int updatePerson(Person person) {
//		return jdbcTemplate.update("Update Person set name=?, location=?, birth_date=? where id=?",
//				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()),
//						person.getId() });
//	}
	
}
