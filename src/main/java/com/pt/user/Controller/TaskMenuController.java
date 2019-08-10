package com.pt.user.Controller;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;
import com.pt.user.dto.TaskMenuDTO;
import com.pt.user.model.TaskMenu;
import com.pt.user.service.TaskMenuService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value = "Users", description = "Operations pertaining to users")
@Controller
@Path("/pt/taskmenu/")
public class TaskMenuController {

	@Autowired
	TaskMenuService tmService;

	@CrossOrigin
	@PostMapping(path = "v1/addTask", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<ResponseMessage> addTaskMenu(@RequestBody TaskMenuDTO tmDTO) {
		log.info("entering TaskMenuController : addTaskMenu", tmDTO);
		tmService.addTaskMenu(tmDTO);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
		responseMessage.setMessage("added");
		log.info("exiting TaskMenuController : addTaskMenu");
		return ResponseEntity.ok().body(responseMessage);
	}
	
	@CrossOrigin
	@GetMapping(path="v1/getMenu")
	public ResponseEntity<List<TaskMenu>> getTaskMenu(){
		log.info("entering TaskMenuController : getTaskMenu");
		List<TaskMenu> tms = tmService.getTaskMenu();
		log.info("exiting TaskMenuController : getTaskMenu");
		return ResponseEntity.ok().body(tms);
	}

}
