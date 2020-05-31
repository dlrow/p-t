package com.pt.admin.service.restful;

import java.util.List;

import com.pt.admin.helper.dto.SchoolDTO;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


public interface ISchoolService {

    String addSchool(SchoolDTO schoolDTO);


    SchoolDTO getSchool(String schoolId);
    
    List<SchoolDTO> getAllSchool();


    String updateSchool(SchoolDTO schoolDTO);


    String hardDeleteSchool(String schoolId);


    String softDeleteSchool(String schoolId);
}
