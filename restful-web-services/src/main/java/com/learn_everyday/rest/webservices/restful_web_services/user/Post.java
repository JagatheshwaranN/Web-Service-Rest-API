package com.learn_everyday.rest.webservices.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity(name = "post")
public class Post {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 10)
	private String description;

	// Basically, it will fetch the posts details after the user details.
	// If its Eager, then both the User and Post details will be fetched at the same
	// time.
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	protected Post() {

	}

	public Post(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

}
