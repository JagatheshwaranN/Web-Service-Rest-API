package com.learn_everyday.spring_security.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.learn_everyday.spring_security.secure.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecureConfig {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN").requestMatchers("/public/**")
						.permitAll().anyRequest().authenticated())
				// httpSecurity.formLogin(Customizer.withDefaults());
				.httpBasic(Customizer.withDefaults())
				// HTTP Session Management has issue with Form Login. It will ask for login
				// every time.
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

//	@Bean
//	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		return httpSecurity.csrf(customizer -> customizer.disable())
//				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
//				// httpSecurity.formLogin(Customizer.withDefaults());
//				.httpBasic(Customizer.withDefaults())
//				// HTTP Session Management has issue with Form Login. It will ask for login
//				// every time.
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
//	}

//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		UserDetails user1 = User.withDefaultPasswordEncoder().username("john").password("2345").roles("USER").build();
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("alex").password("5678").roles("USER").build();
//		UserDetails user3 = User.withDefaultPasswordEncoder().username("erick").password("9876").roles("USER").build();
//
//		// Approach 1
//		// return new InMemoryUserDetailsManager(user1, user2, user3);
//
//		// Approach 2
//		List<UserDetails> users = new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//		return new InMemoryUserDetailsManager(users);
//	}

	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Bean
	public AuthenticationManager getAuthenticationManager() {
		return new ProviderManager(List.of(getAuthenticationProvider()));
	}

}
