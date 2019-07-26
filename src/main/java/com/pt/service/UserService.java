package com.pt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.config.DbChannel;
import com.pt.mongoDomain.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	DbChannel dbChannel;


	public List<User> getUser() {
		log.debug("QuestionService : getUser ");
		List<User> users = dbChannel.findAll();
		return users;
	}


	public void addUser(String name, String phone) {
		User u = new User();
		u.setName(name);
		u.setPhone(phone);
		dbChannel.addUser(u);
		
	}

}
