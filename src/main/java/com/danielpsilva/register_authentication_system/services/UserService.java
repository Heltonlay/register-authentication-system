package com.danielpsilva.register_authentication_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danielpsilva.register_authentication_system.entities.User;
import com.danielpsilva.register_authentication_system.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		if (!obj.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return obj.get();
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public List<User> findByUsername(String username) {
		return repo.findByUsername(username);
	}

	public String insert(User obj) {
		User newUser = repo.insert(obj);
		return newUser.getId();
	}

	public void update(User obj) {
		User user = findById(obj.getId());
		user.setUsername(obj.getUsername());
		user.setEmail(obj.getEmail());
		user.setPassword(obj.getPassword());
		repo.save(user);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
}
