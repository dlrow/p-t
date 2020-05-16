package com.pt.teacher.repository;

import com.pt.teacher.model.ClassDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Purpose:-This interface helps in manipulating data of class details stored in our system
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-08
 */
public interface IClassRepository extends MongoRepository<ClassDetails, String> {

    ClassDetails findByClassId(String uuid);

    List<ClassDetails> deleteByClassId(String classId);

    List<ClassDetails>  findAllByClassId(ArrayList<String> classIds);
}
