package com.danielpsilva.register_authentication_system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	protected UserDetailsService users() {
		UserDetails user = User.builder().username("blah").password("{noop}blah").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user);
	}
}
