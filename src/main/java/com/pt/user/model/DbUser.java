package com.pt.user.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")
public class DbUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;

	private String name;

	private String phone;

	private String pin;

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
