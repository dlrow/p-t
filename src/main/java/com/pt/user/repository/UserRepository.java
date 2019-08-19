package com.pt.user.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pt.user.model.User;

@Configuration
public interface UserRepository extends MongoRepository<User, String> {

	User findByPhone(String phone);

}