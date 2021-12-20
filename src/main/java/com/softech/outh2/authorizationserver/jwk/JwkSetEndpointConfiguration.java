package com.softech.outh2.authorizationserver.jwk;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;

@Configuration
@Order(1)
class JwkSetEndpointConfiguration extends AuthorizationServerSecurityConfiguration {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
			.requestMatchers()
				.mvcMatchers("/oauth2/jwks.json")
				.mvcMatchers("/oauth2/token_key")
				.and()
			.authorizeRequests()
				.mvcMatchers("/oauth2/jwks.json").permitAll()
				.mvcMatchers("/oauth2/token_key").permitAll();
	}
}