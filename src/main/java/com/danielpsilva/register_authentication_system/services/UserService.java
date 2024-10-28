package com.danielpsilva.register_authentication_system.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielpsilva.register_authentication_system.entities.User;
import com.danielpsilva.register_authentication_system.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.get();
	}

	public String insertUser(User obj) {
		User newUser = repo.insert(obj);
		return newUser.getId();
	}
}
