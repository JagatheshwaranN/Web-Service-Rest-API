package com.learn_everyday.learn_spring_jdbc.spring_jdbc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirth_date(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}

//	public List<Person> findAllPerson() {
//		return jdbcTemplate.query("Select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
//	}
	
	public List<Person> findAllPerson() {
		return jdbcTemplate.query("Select * from Person", new PersonRowMapper());
	}

	@SuppressWarnings("deprecation")
	public Person findPersonbyId(int id) {
		return jdbcTemplate.queryForObject("Select * from Person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deletePersonbyId(int id) {
		return jdbcTemplate.update("Delete from Person where id=?", new Object[] { id });
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("Insert into Person (id, name, location, birth_date) Values (?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirth_date().getTime()) });
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update("Update Person set name=?, location=?, birth_date=? where id=?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()),
						person.getId() });
	}
	
}
