package com.learn_everyday.learn_spring_data_jpa.spring_data_jpa.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
//@Table(name = "Person") - Can be used if in case, the table and POJO class names are different.
//@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {

	@Id
	@GeneratedValue
	private int id;
	
//	@Column(name = "name") - Can be used if in case, the table column and POJO class field names are different.
	private String name;
	private String location;
	private Date birth_date;
	
	public Person() {
		
	}
	
	public Person(String name, String location, Date birth_date) {
		super();
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public Person(int id, String name, String location, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birth_date=" + birth_date + "]";
	}

}
