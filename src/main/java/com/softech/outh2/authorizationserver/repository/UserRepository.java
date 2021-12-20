package com.softech.outh2.authorizationserver.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softech.outh2.authorizationserver.jpa.entity.User;

public interface UserRepository extends JpaRepository<User,UUID> {

	Optional<User> findByUsername(String username);

}
