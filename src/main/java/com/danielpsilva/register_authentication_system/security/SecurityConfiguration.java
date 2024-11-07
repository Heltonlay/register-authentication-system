package com.danielpsilva.register_authentication_system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	CustomUserDetailsService userDetailsService;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/users", "/users/login")
						.permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
				.build();
	}

	@Bean
	protected AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
}
