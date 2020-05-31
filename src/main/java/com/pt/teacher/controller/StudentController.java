package com.pt.teacher.controller;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.helper.dto.ResponseMessage;
import com.pt.teacher.helper.dto.StudentDetailsDTO;
import com.pt.teacher.model.StudentDetails;
import com.pt.teacher.service.restful.IStudentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Purpose:- This is a student controller that routes different incoming
 * requests related to student which is done by teacher.
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since 2019-07-28
 *
 **/
@Slf4j
@Api(value = "Student", description = "Student details related apis")
@RestController
@RequestMapping("/pt/student")
//TODO move everything related to student in parent folder
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@CrossOrigin
	@PostMapping(path = "/addstudent", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
	public ResponseEntity<ResponseMessage> addStudent(@RequestBody StudentDetailsDTO studentDetailsDTO) {
		log.info(
				"Executing StudentController.addStudent() with param studentDetailsDTO:{}"
						+ " Routing the incoming request to studentService to add the student to our System.",
				studentDetailsDTO);
		String returnedStudentId = studentService.addStudent(studentDetailsDTO);
		ResponseMessage msg = new ResponseMessage();
		msg.setStatusCode(GeneralConstants.SUCCESS_CODE);
		msg.setMessage(returnedStudentId);
		log.info(
				"Returning the Response Message which consist of studentId for Saved student and Success code from StudentController.addStudent()");
		return ResponseEntity.ok().body(msg);

	}

	@CrossOrigin
	@GetMapping(path = "/getstudent/{studentid}")
	public ResponseEntity<StudentDetailsDTO> getStudent(@PathVariable("studentid") String studentId) {
		log.info("Executing StudentController.getStudent() with param studentId:{}"
				+ "  Routing the incoming request to studentService to get the student details.", studentId);
		StudentDetailsDTO studentDetailsDTO = studentService.getStudent(studentId);
		log.info(
				"Returning the studentDetailsDTO which consist student details of Saved student from StudentController.getStudent()");
		return ResponseEntity.ok().body(studentDetailsDTO);
	}

	// TODO student can be updated to next class i.e from class 2A to 3A etc
	@CrossOrigin
	@PutMapping(path = "/updatestudent")
	public ResponseEntity<ResponseMessage> updateStudent(@RequestBody StudentDetailsDTO studentDetailsDTO) {
		log.info(
				"Executing StudentController.updateStudent() with param studentDetailsDTO:{}"
						+ "Routing the incoming request to studentService to update the student details.",
				studentDetailsDTO);
		String returnedMsg = studentService.updateStudent(studentDetailsDTO);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
		responseMessage.setMessage(returnedMsg);
		log.info("Returning the Response Message which consist of Success Msg and Success code  after Successful"
				+ " updation in student details" + "from StudentController.updateStudent()");
		return ResponseEntity.ok().body(responseMessage);
	}

	@CrossOrigin
	@DeleteMapping(path = "/deletestudent/{studentid}")
	public ResponseEntity<ResponseMessage> deleteStudent(@PathVariable("studentid") String studentId) {
		log.info("Executing StudentController.deleteStudent() with param studentId:{}"
				+ "  Routing the incoming request to studentService to delete the student details from our System.",
				studentId);
		String returnedMessage = studentService.deleteStudent(studentId);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage(returnedMessage);
		responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
		log.info("Returning the Response Message which consist of Success Msg and Success code  after Successful"
				+ " deletion of student details" + "from StudentController.deleteStudent()");
		return ResponseEntity.ok().body(responseMessage);
	}

	@CrossOrigin
	@GetMapping(path = "/allstudent/{classid}")
	public ResponseEntity<List<StudentDetailsDTO>> getAllStudent(@PathVariable("classid") String classId) {
		log.info(
				"Executing StudentController.getAllStudent() with param classId:{}"
						+ "  Routing the incoming request to studentService to get all the student from our System.",
				classId);
		List<StudentDetailsDTO> listOfStudent = studentService.getAllStudents(classId);
		log.info("Returning all student of same class from Executing StudentController.getAllStudent()");
		return ResponseEntity.ok().body(listOfStudent);
	}

}
