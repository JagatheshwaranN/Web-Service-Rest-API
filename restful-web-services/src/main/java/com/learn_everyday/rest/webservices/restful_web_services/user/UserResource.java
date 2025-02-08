package com.learn_everyday.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {

	private UserDaoService userDaoService;

	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return this.userDaoService.findAll();
	}

	// EntityModel - In order to provide links with the actual response [HATEOAS]
	//WebMvcLinkBuilder
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = this.userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+id);
		}
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id) {
//		User user = this.userDaoService.findOne(id);
//		if(user == null) {
//			throw new UserNotFoundException("id: "+id);
//		}
//		return this.userDaoService.findOne(id);
//	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = this.userDaoService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		this.userDaoService.deleteById(id);		
	}

}
