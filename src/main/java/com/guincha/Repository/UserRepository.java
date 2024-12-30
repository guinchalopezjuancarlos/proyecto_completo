package com.guincha.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.User;

import java.util.Optional;
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByUsername(String username); 

    User findByEmail(String email);
}
