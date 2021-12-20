package com.softech.outh2.authorizationserver.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.softech.outh2.authorizationserver.jpa.entity.Client;
import com.softech.outh2.authorizationserver.repository.ClientRepository;
@Primary
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
	private final static Logger logger = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);
	private ClientRepository clientRepository;


	public ClientDetailsServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}


	@SuppressWarnings("deprecation")
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		logger.info("Client Id: "+clientId );
		Client client = clientRepository.findByClientId(clientId);
//		logger.info("Client Entity: "+client );
		return mapToClient(client);
	}

	public ClientDetails updatePassword(ClientDetails clientDetail, String newPassword) {
		Client client = clientRepository.findByClientId(clientDetail.getClientId());
		client.setClientSecret(newPassword);
		client = clientRepository.save(client);
		return mapToClient(client);
	}

	private com.softech.outh2.authorizationserver.dto.Client mapToClient(Client client) {
		logger.info("Client Id(mapToClient): " );
		com.softech.outh2.authorizationserver.dto.Client c = new com.softech.outh2.authorizationserver.dto.Client();
		c.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
		c.setAdditionalInformation(client.getAdditionalInformation());
		c.setAutoApprove(client.isAutoApprove());
		c.setClientId(client.getClientId());
		c.setClientSecret(client.getClientSecret());
		c.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());
//		logger.info("getRegisteredRedirectUri:"+client.getRegisteredRedirectUris().stream().map(ru->ru.getRegisteredRedirectUri()).collect(Collectors.joining(" , ")));
		c.setRegisteredRedirectUri(client.getRegisteredRedirectUris().stream().map(ru->ru.getRegisteredRedirectUri()).collect(Collectors.toSet()));
		c.setResourceIds(client.getResourceIds().stream().map(resource->resource.getResourceName()).collect(Collectors.toSet()));
		c.setScope(client.getScope().stream().map(scope->scope.getScopeName()).collect(Collectors.toSet()));
		c.setSecretRequired(client.isSecretRequired());
		c.setRoles(client.getRoles().stream().map(role->role.getRoleName()).collect(Collectors.toSet()));
		c.setAuthorizedGrantTypes(client.getAuthorizationGrantTypes().stream().map(agt->agt.getAuthorizationGrantType()).collect(Collectors.toSet()));
		c.setGrantedAuthorities(client.getRoles().stream().map(role ->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet()));
		Map<String, Object> additionalInformation = new HashMap<>();
		additionalInformation.put("iat", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
		c.setAdditionalInformation(additionalInformation);
		logger.info("Client: "+ c);
		return c;
	}

}
