package com.softech.outh2.authorizationserver.jpa.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table( name = "user")
public class User{
	private static final long serialVersionUID = -8637774758399966568L;
	@Id
	@Column(name = "id")
	private String id;
	@Column(name ="password" )
	private String password;
	@Column(name ="username")
	private String username;
	@Column(name ="isAccountNonExpired")
	private boolean isAccountNonExpired;
	@Column(name ="isAccountNonLocked")
	private boolean isAccountNonLocked;
	@Column(name ="isCredentialsNonExpired")
	private boolean isCredentialsNonExpired;
	@Column(name ="isEnabled")
	private boolean isEnabled;
	@ManyToMany(cascade =  { CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_role", 
	        joinColumns = { @JoinColumn(name = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "role_id") }
	    )
	private List<Role> roles;
	@Column(name ="phone")
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


}
