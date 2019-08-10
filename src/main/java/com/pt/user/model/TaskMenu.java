package com.pt.user.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "task_menu")
public class TaskMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;

	private String task;

	private String description;
	
	private String taskImage;

}
