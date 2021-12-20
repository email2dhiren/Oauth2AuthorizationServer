package com.softech.outh2.authorizationserver.jpa.entity;

import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "client_id")
	private String clientId;
	@Column(name = "client_secret")
	private String clientSecret;
	@OneToMany(targetEntity = Resource.class, mappedBy = "clientId", fetch = FetchType.EAGER)
	private Set<Resource> resourceIds;
	@Column(name = "is_secret_required")
	private boolean isSecretRequired;
	@Column(name = "is_scoped")
	private boolean isScoped;
	@Column(name = "is_auto_approve")
	private boolean isAutoApprove;
	@OneToMany(targetEntity = RegisteredRedirectUri.class, mappedBy = "clientId", fetch = FetchType.EAGER)
	private Set<RegisteredRedirectUri> registeredRedirectUris;
	@Column(name = "access_token_validity_seconds")
	private Integer accessTokenValiditySeconds;
	@Column(name = "refresh_token_validity_seconds")
	private Integer refreshTokenValiditySeconds;
//	private Map<String, Object> additionalInformation;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "client_scope", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "scope_id"))
	private Set<Scope> scope;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "client_role", joinColumns = @JoinColumn(name = "clientId"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "client_authorization_grant_type", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "authorization_grant_type_id"))
	private Set<AuthorizationGrantType> authorizationGrantTypes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public boolean isSecretRequired() {
		return isSecretRequired;
	}

	public void setSecretRequired(boolean isSecretRequired) {
		this.isSecretRequired = isSecretRequired;
	}

	public boolean isScoped() {
		return isScoped;
	}

	public void setScoped(boolean isScoped) {
		this.isScoped = isScoped;
	}

	public boolean isAutoApprove() {
		return isAutoApprove;
	}

	public void setAutoApprove(boolean isAutoApprove) {
		this.isAutoApprove = isAutoApprove;
	}

	public Set<RegisteredRedirectUri> getRegisteredRedirectUris() {
		return registeredRedirectUris;
	}

	public void setRegisteredRedirectUris(Set<RegisteredRedirectUri> registeredRedirectUris) {
		this.registeredRedirectUris = registeredRedirectUris;
	}

	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

	public Set<Scope> getScope() {
		return scope;
	}

	public void setScope(Set<Scope> scope) {
		this.scope = scope;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Resource> getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(Set<Resource> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
		return authorizationGrantTypes;
	}

	public void setAuthorizationGrantTypes(Set<AuthorizationGrantType> authorizationGrantTypes) {
		this.authorizationGrantTypes = authorizationGrantTypes;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientId=" + clientId + ", clientSecret=" + clientSecret + ", resourceIds="
				+ resourceIds + ", isSecretRequired=" + isSecretRequired + ", isScoped=" + isScoped + ", isAutoApprove="
				+ isAutoApprove + ", registeredRedirectUris=" + registeredRedirectUris + ", accessTokenValiditySeconds="
				+ accessTokenValiditySeconds + ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds
				+ ", scope=" + scope + ", roles=" + roles + ", authorizationGrantTypes=" + authorizationGrantTypes
				+ "]";
	}
}
