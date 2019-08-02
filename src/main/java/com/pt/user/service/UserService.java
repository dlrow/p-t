package com.pt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.teacher.helper.util.UuidGenerator;
import com.pt.user.config.DbChannel;
import com.pt.user.dto.UserDTO;
import com.pt.user.model.User;
import com.pt.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	DbChannel dbChannel;

	@Autowired
	private UuidGenerator uuidGenerator;

	@Autowired
	UserRepository userRepository;

	public void addUser(UserDTO userDTO) {
		User u = new User();
		u.setName(userDTO.getName());
		u.setPhone(userDTO.getPhone());
		// need to encode and save the pin
		u.setPin(userDTO.getPin());
		u.setAddress(userDTO.getAddress());
		u.setUserType(userDTO.getUserType());
		dbChannel.addUser(u);
	}

	public String login(String phone, String pin) {
		User u = userRepository.findByPhone(phone);
		if (u.getPin().equals(pin)) {
			String accessToken = uuidGenerator.getUuid().toString();
			u.setAccessToken(accessToken);
			userRepository.save(u);
			return accessToken;
		} else {
			return "Invalid pin";
		}
	}

	public UserDTO isAuthenticated(String phone, String accesstoken) {
		User u = userRepository.findByPhone(phone);
		if (u.getAccessToken() != null && u.getAccessToken().equals(accesstoken)) {
			UserDTO uDto = new UserDTO();
			uDto.setUserType(u.getUserType());
			uDto.setName(u.getName());
			uDto.setPhone(u.getPhone());
			return uDto;
		}
		return null;
	}

}
