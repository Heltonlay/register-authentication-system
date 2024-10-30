package com.danielpsilva.register_authentication_system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danielpsilva.register_authentication_system.entities.User;
import com.danielpsilva.register_authentication_system.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}

		return new CustomUserDetails(user);
	}

}
