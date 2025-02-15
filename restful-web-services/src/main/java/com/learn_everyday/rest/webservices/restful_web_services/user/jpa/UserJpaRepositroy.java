package com.learn_everyday.rest.webservices.restful_web_services.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn_everyday.rest.webservices.restful_web_services.user.User;

public interface UserJpaRepositroy extends JpaRepository<User, Integer> {

}
