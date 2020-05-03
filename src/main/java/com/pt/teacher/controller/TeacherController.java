package com.pt.teacher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.AttendenceDTO;
import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.helper.dto.ResponseMessage;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "Teacher")
@RestController
@RequestMapping("/pt/teacher")
public class TeacherController {

	// returns list of classIds along with className related to the teacher
	@CrossOrigin
	@GetMapping(path = "/class/{teacherId}")
	public ResponseEntity<ResponseMessage> getClassList(@PathVariable("teacherId") String teacherId) {
		log.info("inside TeacherController : getClassList method called with teacherId:{}", teacherId);
		ResponseMessage responseMessage = new ResponseMessage();
		return ResponseEntity.ok().body(responseMessage);
	}

	// adds a teacher to mongoDocument
	@CrossOrigin
	@PostMapping(path = "/add", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public void addClass() {

	}

	// TODO similar api's to update and remove teacher

}
