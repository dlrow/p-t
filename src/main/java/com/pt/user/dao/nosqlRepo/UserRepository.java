package com.pt.user.dao.nosqlRepo;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pt.user.mongoDomain.User;

@Configuration
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByIdLike(String topic);
}