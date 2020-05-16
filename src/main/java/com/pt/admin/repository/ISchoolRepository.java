package com.pt.admin.repository;

import com.pt.admin.model.SchoolDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


public interface ISchoolRepository  extends MongoRepository<SchoolDetails,String> {

    SchoolDetails findBySchoolId(String schoolId);
    SchoolDetails deleteBySchoolId(String schoolId);
}
