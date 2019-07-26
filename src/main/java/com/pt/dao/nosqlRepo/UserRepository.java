package com.pt.dao.nosqlRepo;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pt.mongoDomain.User;

@Configuration
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByIdLike(String topic);
}