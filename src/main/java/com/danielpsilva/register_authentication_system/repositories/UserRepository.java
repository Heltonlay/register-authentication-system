package com.danielpsilva.register_authentication_system.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.danielpsilva.register_authentication_system.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{'username' : { $regex : ?0 } }")
	public List<User> findByUsername(String username);
}
