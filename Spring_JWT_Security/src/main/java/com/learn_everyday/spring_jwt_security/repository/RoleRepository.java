package com.learn_everyday.spring_jwt_security.repository;

import com.learn_everyday.spring_jwt_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
