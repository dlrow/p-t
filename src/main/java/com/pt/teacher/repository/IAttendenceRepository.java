package com.pt.teacher.repository;


import com.pt.teacher.model.Attendence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Purpose:-This interface helps in manipulating attendence record saved in our System
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-19
 */
public interface IAttendenceRepository extends MongoRepository<Attendence,String> {

    List<Attendence> findByClassId(String classId);
    Attendence findByStudentId(String studentId);
}
