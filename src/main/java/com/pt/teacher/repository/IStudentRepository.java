package com.pt.teacher.repository;

import com.pt.teacher.model.ClassDetails;
import com.pt.teacher.model.StudentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

/**
 * Purpose:-This interface helps in manipulating data of student details stored in our system
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-01
 */
public interface    IStudentRepository extends MongoRepository<StudentDetails,String> {

    StudentDetails findByStudentId(String studentId);

    StudentDetails deleteByStudentId(String studentId);

    List<StudentDetails> deleteByClassId(String classid);

    List<StudentDetails> findByClassId(String classId);
}
