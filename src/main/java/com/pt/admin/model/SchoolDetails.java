package com.pt.admin.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/

@Data
@Document(collection = "schooldetails")
public class SchoolDetails {

    @Id
    @Field("_id")
    private String schoolId;
    private String schoolName;
    private String schoolAddress;
    private String schoolCity;
    private String schoolState;
    private String schoolPincode;
    private Boolean isSchoolDeleted;
    private List<String> schoolAdminIds;

}
