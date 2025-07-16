package com.learn_everyday.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn_everyday.spring_security.model.UserPrincipal;
import com.learn_everyday.spring_security.model.Users;
import com.learn_everyday.spring_security.repository.UserDetailsRepo;

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
