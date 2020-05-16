package com.pt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.user.config.DbChannel;
import com.pt.user.dto.LoginResponseDTO;
import com.pt.user.dto.UserDTO;
import com.pt.user.model.DbUser;
import com.pt.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements GeneralConstants {

	@Autowired
	DbChannel dbChannel;


	@Autowired
	UserRepository userRepository;

	public void addUser(UserDTO userDTO) {
		DbUser u = new DbUser();
		u.setName(userDTO.getName());
		u.setPhone(userDTO.getPhone());
		// TODO need to encode and save the pin
		u.setPin(userDTO.getPin());
		u.setAddress(userDTO.getAddress());
		u.setSchoolId(userDTO.getSchoolId());
		u.setUserType(userDTO.getUserType());
		u.setAuthorizedFor(userDTO.getAuthorizedFor());
		u.setClassIds(userDTO.getClassIds());
		u.setStudentIds(userDTO.getStudentIds());
		dbChannel.addUser(u);
	}

	public LoginResponseDTO login(String phone, String pin) {
		log.info("UserService : login {}", phone);
		DbUser u = userRepository.findByPhone(phone);
		if (u.getPin().equals(pin)) {
			String accessToken = uuidGenerator.getUuid().toString();
			u.setAccessToken(accessToken);
			userRepository.save(u);
			LoginResponseDTO loginResponse = new LoginResponseDTO();
			loginResponse.setAccessToken(accessToken);
			loginResponse.setAddress(u.getAddress());
			loginResponse.setAuthorizedFor(u.getAuthorizedFor());
			loginResponse.setClassIds(u.getClassIds());
			loginResponse.setName(u.getName());
			loginResponse.setSchoolId(u.getSchoolId());
			loginResponse.setStudentIds(u.getStudentIds());
			loginResponse.setUserType(u.getUserType());
			return loginResponse;
		}
		throw new RuntimeException("invalid credentials");
	}

	public UserDTO isAuthenticated(String phone, String accesstoken) {
		DbUser u = userRepository.findByPhone(phone);
		if (u == null)
			throw new RuntimeException("invalid phone");
		if (u.getAccessToken() != null && u.getAccessToken().equals(accesstoken)) {
			UserDTO uDto = new UserDTO();
			uDto.setUserType(u.getUserType());
			uDto.setName(u.getName());
			uDto.setPhone(u.getPhone());
			return uDto;
		}
		throw new RuntimeException("invalid token");
	}

}
