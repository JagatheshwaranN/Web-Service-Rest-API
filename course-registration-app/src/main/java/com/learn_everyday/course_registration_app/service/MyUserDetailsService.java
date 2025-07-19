package com.learn_everyday.course_registration_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn_everyday.course_registration_app.entity.UserPrincipal;
import com.learn_everyday.course_registration_app.entity.Users;
import com.learn_everyday.course_registration_app.repository.UserDetailsRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDetailsRepo.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new UserPrincipal(user);
	}

}
