package com.softech.outh2.authorizationserver.jwk;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;

/**
 * @author manish.kumar4
 *
 */
@SuppressWarnings("deprecation")
@FrameworkEndpoint
public class JwkSetEndpoint {
	private KeyPair keyPair;

	public JwkSetEndpoint() throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "SunRsaSign");
		this.keyPair = keyGen.generateKeyPair();

	}

	@GetMapping("/oauth2/jwks.json")
	@ResponseBody
	public Map<String, Object> getKey(Principal principal) {
		RSAKey.Builder builder = new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
			      .keyUse(KeyUse.SIGNATURE)
			      .algorithm(JWSAlgorithm.RS512)
			      .keyID("bael-key-id");
			    return new JWKSet(builder.build()).toJSONObject();
	}
	
	@GetMapping("/oauth2/token_key")
	@ResponseBody
	public Map<String, String> getKey() {
		Map<String, String> ret = new HashMap<>();
		ret.put("alg",keyPair.getPublic().getAlgorithm());
		ret.put("format",keyPair.getPublic().getFormat());
		ret.put("value",new String(Base64.getEncoder().encode(keyPair.getPublic().getEncoded())));
		return ret;
			    
	}
/*
public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
	JwkSetEndpoint jwkSetEndpoint = new JwkSetEndpoint();
	System.out.println(jwkSetEndpoint.getKey(null));
	
}
*/

	public KeyPair getKeyPair() {
		return keyPair;
	}
}

