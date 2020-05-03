package com.pt.user.dto;

import com.pt.user.model.UType;

import lombok.Data;

@Data
public class UserDTO {

	private String name;

	private String phone;

	private String pin;

	private UType userType;

	private String schoolId;

	// enntityId is parentId/teacherId/pricipalId depending on UType
	private String entityId;
}
