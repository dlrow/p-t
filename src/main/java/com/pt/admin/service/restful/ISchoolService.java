package com.pt.admin.service.restful;

import com.pt.admin.helper.dto.SchoolDTO;
import com.pt.teacher.helper.dto.ClassDetailsDTO;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


public interface ISchoolService {

    String addSchool(SchoolDTO schoolDTO);


    SchoolDTO getSchool(String schoolId);


    String updateSchool(SchoolDTO schoolDTO);


    String hardDeleteSchool(String schoolId);


    String softDeleteSchool(String schoolId);
}
