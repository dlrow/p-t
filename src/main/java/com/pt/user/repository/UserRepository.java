package com.pt.user.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pt.user.model.DbUser;

@Configuration
public interface UserRepository extends MongoRepository<DbUser, String> {

	DbUser findByPhone(String phone);

}