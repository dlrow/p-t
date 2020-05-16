package com.pt.parent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "Parent")
@RestController
@RequestMapping("/pt/parent")
public class ParentController {

	// returns list of students related to the parent
	@CrossOrigin
	@GetMapping(path = "/studennt/{parentId}")
	public ResponseEntity<ResponseMessage> getStudentList(@PathVariable("parentId") String parentId) {
		log.info("inside ParentController : getStudentList method called with parentId:{}", parentId);
		
		return null;
	}

	// adds a parent to mongoDocument
	@CrossOrigin
	@PostMapping(path = "/add", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public void addParent() {

	}

	// TODO similar api's to update and remove parent

}
