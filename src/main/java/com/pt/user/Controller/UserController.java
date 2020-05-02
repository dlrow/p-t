package com.pt.user.Controller;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;
import com.pt.user.dto.LoginDTO;
import com.pt.user.dto.MapResponse;
import com.pt.user.dto.UserDTO;
import com.pt.user.service.UserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "Users", description = "Operations pertaining to users")
@Controller
@Path("/pt/user")
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
	@PostMapping(path = "v1/login", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<MapResponse> login(@RequestBody LoginDTO loginDTO) {
		log.info("entering UserController : login phone:{}", loginDTO.getPhone());
		MapResponse response = userService.login(loginDTO.getPhone(), loginDTO.getPin());
		log.info("exiting UserController : authUser");
		if (response.getResponse().containsKey("error"))
			return ResponseEntity.badRequest().body(response);
		return ResponseEntity.ok().body(response);
	}

	// if user is authentic ? userDto : null
	@CrossOrigin
	@PostMapping(path = "v1/isAuthenticated", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<UserDTO> isAuthenticated(@RequestParam(value = "phone") String phone,
			@RequestParam(value = "accesstoken") String accesstoken) {
		log.info("entering UserController : isAuthenticated", phone);
		UserDTO user = userService.isAuthenticated(phone, accesstoken);
		log.info("exiting UserController : authUser");
		return ResponseEntity.ok().body(user);
	}

}
