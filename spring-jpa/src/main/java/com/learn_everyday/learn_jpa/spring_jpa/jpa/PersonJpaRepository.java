package com.learn_everyday.learn_jpa.spring_jpa.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learn_everyday.learn_jpa.spring_jpa.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
		
	public Person findPersonbyId(int id) {
		return entityManager.find(Person.class, id);
	}

	public Person insertPerson(Person person) {
		return entityManager.merge(person);
	}

	public Person updatePerson(Person person) {
		return entityManager.merge(person);
	}
	
	public void deletePersonbyId(int id) {
		Person person = findPersonbyId(id);
		entityManager.remove(person);
	}
	
	// We have used JPQL - Java Persistence Query Language with the help of Named Query concept.
	// The query is defined inside the Entity class.
	public List<Person> findAllPersons() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
}
