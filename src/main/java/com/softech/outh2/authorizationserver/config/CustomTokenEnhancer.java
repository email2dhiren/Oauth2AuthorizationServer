package com.softech.outh2.authorizationserver.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
@Component
public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		Map<String, Object> additionalInformation = accessToken.getAdditionalInformation();
		if (additionalInformation.isEmpty()) {
			additionalInformation = new LinkedHashMap<String, Object>();
		}
		// add "iat" claim with current time in secs
		// this is used for an inactive session timeout
		additionalInformation.put("iat", new Integer((int) (System.currentTimeMillis() / 1000L)));
		additionalInformation.put("iss","common_user");
		additionalInformation.put("testKey","Test Value");
		token.setAdditionalInformation(additionalInformation);
		return token;
	}

}
