package com.pt.user.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;

	private String name;

	private String phone;
	
	private String pin;

	private String address;

	private UType userType;

	private String accessToken;

	// contains list of students for user_type=parent, list of class for u_t=teacher
	// and shoolid for principal
	private List<String> accessList;

}
