package com.pt.admin.controller;

import com.pt.admin.helper.dto.SchoolDTO;
import com.pt.admin.service.restful.ISchoolService;
import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


@Slf4j
@Api(value = "Admin", description = "Admin related apis")
@RestController
@RequestMapping("/pt/admin/")
public class SchoolController {

    private static final org.slf4j.Logger Logger= LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private ISchoolService schoolService;


    @CrossOrigin
    @PostMapping(path="/add/school",consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public ResponseEntity<ResponseMessage> addSchool(@RequestBody SchoolDTO schoolDTO)
    {
        Logger.info("Executing SchoolController.addSchool() with param schoolDTO:{}"+
                "  Routing the incoming request to schoolService to add the school.",schoolDTO);
        String schoolId=schoolService.addSchool(schoolDTO);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage(schoolId);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        Logger.info("Returning the Response Message which consist of schoolID for Saved school and Success code from SchoolController.addSchool()");
        return ResponseEntity.ok().body(responseMessage);
    }



    @CrossOrigin
    @GetMapping(path="/get/school/{schoolid}")
    public ResponseEntity<SchoolDTO> getSchool(@PathVariable("schoolid") String schoolid)
    {
        Logger.info("Executing SchoolController.getSchool() with param schoolid:{}"+
                "  Routing the incoming request to schoolService to get the school details.",schoolid);
        SchoolDTO schoolDTO=schoolService.getSchool(schoolid);
        Logger.info("Returning the SchoolDTO which consist school details of Saved school SchoolController.getSchool()");
        return ResponseEntity.ok().body(schoolDTO);

    }



    @CrossOrigin
    @PutMapping(path="/update/school",consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public ResponseEntity<ResponseMessage> updateSchool(@RequestBody SchoolDTO schoolDTO)
    {
        log.info("Executing SchoolController.updateSchool() with param SchoolDTO:{}"+
                "  Routing the incoming request to schoolService to update the school.",schoolDTO);
        ResponseMessage responseMessage=new ResponseMessage();
        String msg=schoolService.updateSchool(schoolDTO);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        responseMessage.setMessage(msg);
        log.info("Returning the Response Message which consist of Success Msg and Success code  after Successful" +
                " updation in school details" + "from SchoolController.updateSchool()");
        return ResponseEntity.ok().body(responseMessage);
    }

    @CrossOrigin
    @DeleteMapping(path="/delete/school/soft/{schoolid}")
    public ResponseEntity<ResponseMessage> softDeleteSchool(@PathVariable("schoolid") String schoolid)
    {
        Logger.info("Executing SchoolController.softDeleteSchool() with param classid:{}"+
                "  Routing the incoming request to classService to delete the class details from our System.",schoolid);
        String msg=schoolService.softDeleteSchool(schoolid);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage(msg);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        Logger.info("Returning the Response Message which consist of Success Msg and Success code  after Successful" +
                "soft deletion of school details" + "from SchoolController.softDeleteSchool()");
        return ResponseEntity.ok().body(responseMessage);

    }

    @CrossOrigin
    @DeleteMapping(path="/delete/school/hard/{schoolid}")
    public ResponseEntity<ResponseMessage> hardDeleteSchool(@PathVariable("schoolid") String schoolid)
    {
        Logger.info("Executing SchoolController.hardDeleteSchool() with param classid:{}"+
                "  Routing the incoming request to classService to delete the class details from our System.",schoolid);
        String msg=schoolService.hardDeleteSchool(schoolid);
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setMessage(msg);
        responseMessage.setStatusCode(GeneralConstants.SUCCESS_CODE);
        Logger.info("Returning the Response Message which consist of Success Msg and Success code  after Successful" +
                " hard deletion of school details" + "from SchoolController.hardDeleteSchool()");
        return ResponseEntity.ok().body(responseMessage);

    }
}
