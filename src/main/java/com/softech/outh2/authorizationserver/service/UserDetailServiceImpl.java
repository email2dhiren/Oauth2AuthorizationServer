package com.softech.outh2.authorizationserver.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softech.outh2.authorizationserver.jpa.entity.User;
import com.softech.outh2.authorizationserver.repository.UserRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService {
    private final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

	private UserRepository userRepository;

	public UserDetailServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();
		return mapToUser(user);
	}

	@Override
	public UserDetails updatePassword(UserDetails userDetail, String newPassword) {
		User user = userRepository.findByUsername(userDetail.getUsername()).get();
		user.setPassword(newPassword);
		user = userRepository.save(user);
		return mapToUser(user);
	}

	private com.softech.outh2.authorizationserver.dto.User mapToUser(User user) {
		com.softech.outh2.authorizationserver.dto.User u = new com.softech.outh2.authorizationserver.dto.User();
		u.setAccountNonExpired(user.isAccountNonExpired());
		u.setAccountNonLocked(user.isAccountNonLocked());
		u.setCredentialsNonExpired(user.isCredentialsNonExpired());
		u.setRoles(user.getRoles());
		u.setId(user.getId());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		u.setEnabled(user.isEnabled());
		Map<String, Object> additionalInformation = new HashMap<>();
		additionalInformation.put("iat", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
		u.setAdditionalInformation(additionalInformation);
		log.info("User:"+ u);
		return u;
	}

}
