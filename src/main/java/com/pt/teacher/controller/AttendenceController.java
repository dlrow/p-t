package com.pt.teacher.controller;


import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.AttendenceDTO;
import com.pt.teacher.helper.dto.ResponseMessage;
import com.pt.teacher.helper.dto.StudentDetailsDTO;
import com.pt.teacher.model.Attendence;
import com.pt.teacher.service.restful.IAttendenceService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/pt/teacher/attendence/student")
public class AttendenceController {

    @Autowired
    private IAttendenceService attendenceService;

    @CrossOrigin
    @PostMapping(path="/mark/{classid}",consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public ResponseEntity<ResponseMessage> markAttendence(@PathVariable("classid") String classid,@RequestBody AttendenceDTO attendenceDTO)
    {
        log.info("Executing AttendenceController.markAttendence() with param attendenceDTO:{}"+
                " Routing the incoming request to attendenceService to mark the attendence of Student.",attendenceDTO);
        String msgToSend=attendenceService.markAttendence(attendenceDTO,classid);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage(msgToSend);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        log.info("Returning the Response Message which consist of Success Msg when attendence of student have been marked from AttendenceController.markAttendence()");
        return ResponseEntity.ok().body(responseMessage);
    }

    @CrossOrigin
    @GetMapping(path="/unmarked/{classid}")
    public ResponseEntity<List<StudentDetailsDTO>> getUnMarkedStudent(@PathVariable("classid") String classid)
    {
        log.info("Executing AttendenceController.getUnMarkedStudent() with param classid:{}"+
                " Routing the incoming request to attendenceService to get the list of unmarked(absent) Student.",classid);
        List<StudentDetailsDTO> unmarkedStudent=attendenceService.getUnMarkedStudent(classid);
        log.info("Returning the List of unmarked Student from AttendenceController.getUnMarkedStudent()");
        return ResponseEntity.ok().body(unmarkedStudent);
    }


    @CrossOrigin
    @GetMapping(path="/marked/{classid}")
    public ResponseEntity<List<StudentDetailsDTO>> getMarkedStudent(@PathVariable("classid") String classid)
    {
        log.info("Executing AttendenceController.getMarkedStudent() with param classid:{}"+
                " Routing the incoming request to attendenceService to get the list of marked(present) Student.",classid);
        List<StudentDetailsDTO> markedStudent=attendenceService.getMarkedStudent(classid);
        log.info("Returning the List of marked(present) Student from AttendenceController.getMarkedStudent()");
        return ResponseEntity.ok().body(markedStudent);
    }

    @CrossOrigin
    @GetMapping(path="/detailsofsinglestudent/{studentId}")
    public ResponseEntity<Attendence> getAttendenceOfAStudent(@PathVariable("studentId") String studentId)
    {
        log.info("Executing AttendenceController.getAttendenceOfAStudent() with param studentId:{}"+
                " Routing the incoming request to attendenceService to get details of attendence of single student",studentId);
        Attendence attendenceDetailsOfSingleStudent =attendenceService.getAttendenceOfAStudent(studentId);
        log.info("Returning the details of attendence of single student from AttendenceController.getAttendenceOfAStudent()");
        return ResponseEntity.ok().body(attendenceDetailsOfSingleStudent);
    }


}
