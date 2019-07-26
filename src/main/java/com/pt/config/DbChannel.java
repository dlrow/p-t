package com.pt.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pt.dao.nosqlRepo.UserRepository;
import com.pt.mongoDomain.User;

@Repository
public class DbChannel {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void addUser(User u) {
		userRepository.save(u);
	}

}
