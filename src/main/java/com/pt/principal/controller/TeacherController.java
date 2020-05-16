package com.pt.principal.controller;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ResponseMessage;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose This is a teacher controller that routes different incoming requests related to teacher which is done by school admin/principal.
 * @since 2020-05-14
 **/


@Slf4j
@Api(value = "Teacher", description = "Teacher details related apis")
@RestController
@RequestMapping("/pt/teacher")
public class TeacherController {

    // returns list of classIds along with className related to the teacher
    @CrossOrigin
    @GetMapping(path = "/class/{teacherId}")
    public ResponseEntity<ResponseMessage> getClassList(@PathVariable("teacherId") String teacherId) {
        log.info("inside TeacherController : getClassList method called with teacherId:{}", teacherId);
        ResponseMessage responseMessage = new ResponseMessage();
        return ResponseEntity.ok().body(responseMessage);
    }

    // adds a teacher to mongoDocument
    @CrossOrigin
    @PostMapping(path = "/add", consumes = GeneralConstants.APPLICATION_JSON_CONTENT_TYPE)
    public void addClass() {

    }

    // TODO similar api's to update and remove teacher

}
