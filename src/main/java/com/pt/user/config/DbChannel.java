package com.pt.user.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pt.user.dao.nosqlRepo.UserRepository;
import com.pt.user.mongoDomain.User;

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