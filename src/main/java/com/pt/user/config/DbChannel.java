package com.pt.user.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pt.user.model.DbUser;
import com.pt.user.repository.UserRepository;

@Repository
public class DbChannel {

	@Autowired
	UserRepository userRepository;

	public List<DbUser> findAll() {
		return userRepository.findAll();
	}

	public void addUser(DbUser u) {
		userRepository.save(u);
	}

}
