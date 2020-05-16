package com.pt.admin.helper.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/

@Data
public class SchoolDTO {

    private String schoolId;
    private String schoolName;
    private String schoolAddress;
    private String schoolCity;
    private String schoolState;
    private String schoolPincode;
    private Boolean isSchoolDeleted;
    private List<String> schoolAdminIds;

}
