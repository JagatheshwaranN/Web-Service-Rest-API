package com.learn_everyday.learn_spring_data_jpa.spring_data_jpa.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn_everyday.learn_spring_data_jpa.spring_data_jpa.entity.Person;


public interface PersonSpringDataJpaRepository extends JpaRepository<Person, Integer> {

}
