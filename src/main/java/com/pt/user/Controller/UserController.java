package com.pt.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;
import com.pt.user.dto.LoginDTO;
import com.pt.user.dto.LoginResponseDTO;
import com.pt.user.dto.UserDTO;
import com.pt.user.model.Tasks;
import com.pt.user.service.UserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

//TODO implement forgot password
@Slf4j
@Api(value = "Users")
@RestController
@RequestMapping("/pt/user")
public class UserController implements GeneralConstants {

	@Autowired
	UserService userService;

	@CrossOrigin
	@PostMapping(path = "v1/addUser", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<ResponseMessage> addUser(@RequestBody UserDTO userDTO) {
		log.info("entering UserController : addUser", userDTO);
		userService.addUser(userDTO);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
		responseMessage.setMessage("added");
		log.info("exiting UserController : addUser");
		return ResponseEntity.ok().body(responseMessage);
	}

	@CrossOrigin
	@GetMapping(path = "v1/allTask")
	public ResponseEntity<Tasks[]> getAllTask() {
		log.info("entering UserController : getAllTask");
		return ResponseEntity.ok().body(Tasks.values());
	}

	@CrossOrigin
	@PostMapping(path = "v1/login", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {
		log.info("entering UserController : login phone:{}", loginDTO.getPhone());
		LoginResponseDTO response = userService.login(loginDTO.getPhone(), loginDTO.getPin());
		log.info("exiting UserController : authUser");
		return ResponseEntity.ok().body(response);
	}

	// if user is authentic ? userDto : null
	@CrossOrigin
	@PostMapping(path = "v1/isAuthenticated", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<Object> isAuthenticated(@RequestParam(value = "phone") String phone,
			@RequestParam(value = "accesstoken") String accesstoken) {
		log.info("entering UserController : isAuthenticated", phone);
		UserDTO user = userService.isAuthenticated(phone, accesstoken);
		log.info("exiting UserController : authUser");
		return ResponseEntity.ok().body(user);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleException(RuntimeException e) {
		log.error("inside UserController : handleException {}", e);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
	}

}
