package com.softech.outh2.authorizationserver.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="redirect_uri")
public class RegisteredRedirectUri {
@Id
@Column(name = "id")
private int id;
@Column(name="uri")
private String registeredRedirectUri;
@Column(name="client_id")
private String clientId;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getRegisteredRedirectUri() {
	return registeredRedirectUri;
}

public void setRegisteredRedirectUri(String registeredRedirectUri) {
	this.registeredRedirectUri = registeredRedirectUri;
}

public String getClientId() {
	return clientId;
}

public void setClientId(String clientId) {
	this.clientId = clientId;
}

@Override
public String toString() {
	return "RegisteredRedirectUri [id=" + id + ", registeredRedirectUri=" + registeredRedirectUri + ", clientId="
			+ clientId + "]";
}
}
