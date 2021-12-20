package com.softech.outh2.authorizationserver.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softech.outh2.authorizationserver.jpa.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

	Client findByClientId(String clientId);

}
