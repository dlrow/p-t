package com.pt.user.dto;

import com.pt.user.model.UType;

import lombok.Data;

@Data
public class UserDTO {

	private String name;

	private String phone;
	
	private String pin;
	
	private String address;

	private UType userType;
}
