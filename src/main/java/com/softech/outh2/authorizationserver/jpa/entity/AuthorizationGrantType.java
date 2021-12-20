package com.softech.outh2.authorizationserver.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "authorization_grant_type")
public class AuthorizationGrantType {
	@Id
	@Column(name = "id")
	private Integer id;
	private String authorizationGrantType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorizationGrantType() {
		return authorizationGrantType;
	}
	public void setAuthorizationGrantType(String authorizationGrantType) {
		this.authorizationGrantType = authorizationGrantType;
	}

}
