package com.pt.teacher.service.restful;


import com.pt.teacher.helper.dto.ClassDetailsDTO;

import java.util.UUID;

/**
 * Purpose:-
 * This interface define all the services related class in school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 */

public interface IClassService {


    /**
     * This method will start saving class to our system
     * @param classDetailsDTO contains class detail
     * @return classId of the saved class
     */
    UUID addClass(ClassDetailsDTO classDetailsDTO);

    /**
     * This method will fetch the class details from our System
     * @param classid represent classid
     * @return classDetailsDto which contains class details
     */
    ClassDetailsDTO getClass(UUID classid);

}
