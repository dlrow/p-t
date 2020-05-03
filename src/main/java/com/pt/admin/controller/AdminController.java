package com.pt.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "Admin")
@RestController
@RequestMapping("/pt/admin")
public class AdminController {

	// TODO create api's to add/remove/update/see school entity
	// also it should add users with type PRINCIPAL/TEACHER/PARENT access to that school
	

}
