package com.pt.teacher.service.restful;

import com.pt.teacher.helper.dto.StudentDetailsDTO;

import java.util.List;
import java.util.UUID;

/**
 * Purpose:-
 * This interface define all the services  which contain business logic related student in school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-01
 */
public interface IStudentService {

    /**
     * This service will have logic for saving student to our System
     * @param studentDetailsDTO contains Student details
     * @return studentId of Student
     */
    String addStudent(StudentDetailsDTO studentDetailsDTO);

    StudentDetailsDTO getStudent(String studentId);

    String updateStudent(StudentDetailsDTO studentDetailsDTO);

    String deleteStudent(String studentId);

    List<StudentDetailsDTO> getAllStudents(String classId);

}
