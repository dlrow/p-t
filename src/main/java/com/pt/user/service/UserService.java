package com.pt.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.util.UuidGenerator;
import com.pt.user.config.DbChannel;
import com.pt.user.dto.MapResponse;
import com.pt.user.dto.UserDTO;
import com.pt.user.model.User;
import com.pt.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements GeneralConstants {

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

	public MapResponse login(String phone, String pin) {
		log.info("UserService : login {}", phone);
		User u = userRepository.findByPhone(phone);
		MapResponse userRes = new MapResponse();
		if (u == null)
			userRes.getResponse().put("error", UNREGISTERD_PHONE);
		else if (u.getPin().equals(pin)) {
			String accessToken = uuidGenerator.getUuid().toString();
			u.setAccessToken(accessToken);
			userRepository.save(u);
			Map<String, String> response = userRes.getResponse();
			response.put("accessToken", accessToken);
			response.put("name", u.getName());
		} else {
			userRes.getResponse().put("error", INVALID_PIN);
		}
		return userRes;
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
