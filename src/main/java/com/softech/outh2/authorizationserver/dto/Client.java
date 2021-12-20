package com.softech.outh2.authorizationserver.dto;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.softech.outh2.authorizationserver.jpa.entity.Scope;

@SuppressWarnings("deprecation")
public class Client implements ClientDetails {
	private static final long serialVersionUID = 1L;
	private String clientId;
	private String clientSecret;
	private Set<String> resourceIds;
	private boolean isSecretRequired;
	private boolean isScoped;
	private boolean isAutoApprove;
	private Set<String> registeredRedirectUri;
	private Integer accessTokenValiditySeconds;
	private Integer refreshTokenValiditySeconds;
	private Map<String, Object> additionalInformation;
	private Set<String> scope;
	private Set<String> roles;
	private Set<String> authorizedGrantTypes;
	private Set<GrantedAuthority> grantedAuthorities;

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
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

	public Set<String> getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(Set<String> resourceIds) {
		this.resourceIds = resourceIds;
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

	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
		this.registeredRedirectUri = registeredRedirectUri;
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
		return additionalInformation;
	}

	public void setAdditionalInformation(Map<String, Object> additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<String> getScope() {
		return this.scope;
	}

	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public Set<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(Set<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientSecret=" + clientSecret + ", resourceIds="
				+ resourceIds + ", isSecretRequired=" + isSecretRequired + ", isScoped=" + isScoped + ", isAutoApprove="
				+ isAutoApprove + ", registeredRedirectUri=" + registeredRedirectUri + ", accessTokenValiditySeconds="
				+ accessTokenValiditySeconds + ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds
				+ ", additionalInformation=" + additionalInformation + ", scope=" + scope + ", roles=" + roles
				+ ", authorizedGrantTypes=" + authorizedGrantTypes + ", grantedAuthorities=" + grantedAuthorities + "]";
	}
}
