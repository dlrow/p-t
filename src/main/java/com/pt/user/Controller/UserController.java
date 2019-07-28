package com.pt.user.Controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt.user.mongoDomain.User;
import com.pt.user.service.UserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "Users", description = "Operations pertaining to users")
@Controller
@Path("/pt/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/v1/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser() {
		log.info("UserController : getUser()");
		userService.getUser();
		return ResponseEntity.status(200).body(userService.getUser());
	}
	
	@RequestMapping(value = "/v1/addUser", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "phone") String phone) {
		log.info("UserController : addUser()");
		
		userService.addUser(name,phone);
		return ResponseEntity.status(200).body("added");
	}
	
}
