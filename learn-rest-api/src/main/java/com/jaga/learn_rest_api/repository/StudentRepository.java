package com.jaga.learn_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jaga.learn_rest_api.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findBySubject(String subject);

	@Query(nativeQuery = true, value = "SELECT * FROM STUDENT WHERE GENDER =:gender AND SUBJECT =:subject")
	List<Student> findByGenderAndSubject(@Param("gender") String gender, @Param("subject") String subject);

}
