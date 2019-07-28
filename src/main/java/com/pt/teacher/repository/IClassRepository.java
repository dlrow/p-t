package com.pt.teacher.repository;

import com.pt.teacher.model.ClassDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * Purpose:-This interface hold the method which will deal with the class details collection in our system.
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-08
 */
public interface IClassRepository extends MongoRepository<ClassDetails, UUID> {

    ClassDetails findByClassId(UUID uuid);
}
