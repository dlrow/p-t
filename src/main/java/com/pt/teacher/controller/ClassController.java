package com.pt.teacher.controller;


import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.helper.dto.ResponseMessage;
import com.pt.teacher.service.restful.IClassService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Purpose:-
 * This is a class controller that routes different incoming requests related to class which is done by teacher.
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 *
 **/
@Slf4j
@Api(value = "Class", description = "Class details related apis")
@RestController
@RequestMapping("/pt/teacher/class")
public class ClassController {

    private static final Logger Logger= LoggerFactory.getLogger(ClassController.class);

    @Autowired
    private IClassService classService;

    /**
     * This Api will be use to save the classDetails of particular class to our System
     * @param classDetailsDTO contains class details
     * @return ResponseMessage which consist success code and uuid of saved class
     */
    @CrossOrigin
    @PostMapping(path="/add",consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public ResponseEntity<ResponseMessage> addClass(@RequestBody ClassDetailsDTO classDetailsDTO)
    {
       Logger.info("Executing ClassController.addClass() with param classDetailsDTO:{}"+
               "  Routing the incoming request to classService to add the class.",classDetailsDTO);
       String classId=classService.addClass(classDetailsDTO);
       ResponseMessage responseMessage=new ResponseMessage();
       responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
       responseMessage.setMessage(classId);
       Logger.info("Returning the Response Message which consist of Uuid for Saved class and Success code from ClassController.addClass()");
       return ResponseEntity.ok().body(responseMessage);
    }

    /**
     * This Api will fetch the class details of given class from our System
     * @param classid it accept classId to fetch the details
     * @return classDetailsDto which contains all the class details
     */
    @CrossOrigin
    @GetMapping(path="/get/{classid}")
    public ResponseEntity<ClassDetailsDTO> getClass(@PathVariable("classid") String classid)
    {
        Logger.info("Executing ClassController.addClass() with param classid:{}"+
                "  Routing the incoming request to classService to get the class details.",classid);
        //UUID classIdUuid=UUID.fromString(classid);
        ClassDetailsDTO classDetailsDTO=classService.getClass(classid);
        Logger.info("Returning the ClassDetailsDTO which consist class details of Saved class ClassController.getClass()");
        return ResponseEntity.ok().body(classDetailsDTO);

    }

    /**
     * This Api will update the class details of saved class
     * @param classDetailsDTO it accept the classDetailsDto consisting of details to be updated
     * @return ResponseMessage which consist of success code and success msg
     */

    @CrossOrigin
    @PutMapping(path="/update",consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public ResponseEntity<ResponseMessage> updateClass(@RequestBody ClassDetailsDTO classDetailsDTO)
    {
        log.info("Executing ClassController.updateClass() with param classDetailsDTO:{}"+
                "  Routing the incoming request to classService to update the class.",classDetailsDTO);
        ResponseMessage responseMessage=new ResponseMessage();
        String msg=classService.updateClass(classDetailsDTO);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        responseMessage.setMessage(msg);
        log.info("Returning the Response Message which consist of Success Msg and Success code  after Successful" +
                " updation in class details" +
                "from ClassController.updateClass()");
        return ResponseEntity.ok().body(responseMessage);
    }

    @CrossOrigin
    @DeleteMapping(path="/delete/{classid}")
    public ResponseEntity<ResponseMessage> deleteClass(@PathVariable("classid") String classid)
    {
        Logger.info("Executing ClassController.deleteClass() with param classid:{}"+
                "  Routing the incoming request to classService to delete the class details from our System.",classid);
        classService.deleteClass(classid);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage(GeneralConstants.SUCCCESS_MSG);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        Logger.info("Returning the Response Message which consist of Success Msg and Success code  after Successful" +
                " deletion of class details" +
                "from ClassController.deleteClass()");
        return ResponseEntity.ok().body(responseMessage);

    }
}
