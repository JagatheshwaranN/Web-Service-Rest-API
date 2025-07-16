package com.learn_everyday.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn_everyday.spring_security.model.Users;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {

	Users getByUsername(String username);

}
