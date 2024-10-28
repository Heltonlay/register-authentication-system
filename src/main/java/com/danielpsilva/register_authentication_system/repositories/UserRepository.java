package com.danielpsilva.register_authentication_system.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danielpsilva.register_authentication_system.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
