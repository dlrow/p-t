package com.pt.user.dto;

import java.util.List;

import com.pt.user.model.Address;
import com.pt.user.model.Tasks;
import com.pt.user.model.UType;

import lombok.Data;

@Data
public class LoginResponseDTO {

	private String name;

	private Address address;

	private String schoolId;

	private String accessToken;

	private UType userType;

	private List<Tasks> authorizedFor;

	// if UType==teacher
	private List<String> classIds;

	// if UType==parent
	private List<String> studentIds;

}
