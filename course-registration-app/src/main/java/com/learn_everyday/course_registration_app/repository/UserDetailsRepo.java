package com.learn_everyday.course_registration_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn_everyday.course_registration_app.entity.Users;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {

	Users getByUsername(String username);

}
