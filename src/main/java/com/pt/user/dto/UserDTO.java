package com.pt.user.dto;

import java.util.List;

import com.pt.user.model.Address;
import com.pt.user.model.Tasks;
import com.pt.user.model.UType;

import lombok.Data;

@Data
public class UserDTO {

	private String name;

	private String phone;

	private String pin;

	private Address address;

	private String schoolId;

	private UType userType;

	private List<Tasks> authorizedFor;

	// if UType==teacher
	private List<String> classIds;

	// if UType==parent
	private List<String> studentIds;
}
