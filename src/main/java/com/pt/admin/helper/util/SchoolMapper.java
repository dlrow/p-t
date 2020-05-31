package com.pt.admin.helper.util;

import com.pt.admin.helper.dto.SchoolDTO;
import com.pt.admin.model.SchoolDetails;
import org.springframework.stereotype.Component;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


@Component
public class SchoolMapper {


    public SchoolDetails mapSchoolDtoToSchoolDetails(SchoolDTO schoolDTO)
    {
        SchoolDetails schoolDetails=new SchoolDetails();
        if(schoolDTO.getSchoolId()!=null)
        {
            schoolDetails.setSchoolId(schoolDTO.getSchoolId());
        }
        schoolDetails.setSchoolAddress(schoolDTO.getSchoolAddress());
        schoolDetails.setSchoolCity(schoolDTO.getSchoolCity());
        schoolDetails.setSchoolState(schoolDTO.getSchoolState());
        schoolDetails.setSchoolPincode(schoolDTO.getSchoolPincode());
        schoolDetails.setSchoolAdminIds(schoolDTO.getSchoolAdminIds());
        schoolDetails.setSchoolName(schoolDTO.getSchoolName());
        schoolDetails.setIsSchoolDeleted(schoolDTO.getIsSchoolDeleted());
        return schoolDetails;
    }

    public SchoolDTO mapSchoolDetailsToSchoolDto(SchoolDetails schoolDetails)
    {
        SchoolDTO schoolDTO=new SchoolDTO();
        schoolDTO.setSchoolId(schoolDetails.getSchoolId());
        schoolDTO.setSchoolName(schoolDetails.getSchoolName());
        schoolDTO.setSchoolAddress(schoolDetails.getSchoolAddress());
        schoolDTO.setSchoolCity(schoolDetails.getSchoolCity());
        schoolDTO.setSchoolState(schoolDetails.getSchoolState());
        schoolDTO.setSchoolAdminIds(schoolDetails.getSchoolAdminIds());
        schoolDTO.setSchoolPincode(schoolDetails.getSchoolPincode());
        schoolDTO.setIsSchoolDeleted(schoolDetails.getIsSchoolDeleted());
        return schoolDTO;
    }
}
