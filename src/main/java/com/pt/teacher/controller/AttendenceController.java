package com.pt.teacher.controller;


import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Purpose:-
 * This is a Attendence controller that routes different incoming requests related to Attendence which is done by teacher.
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 *
 **/
@Slf4j
@Api(value = "Attendence", description = "Attendence related api")
@RestController
@RequestMapping("/pt/teacher/student")
public class AttendenceController {

    @Override
    @PostMapping(path="/markattendence",consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public ResponseEntity<ResponseMessage> markAttendence(@RequestParam )
}
