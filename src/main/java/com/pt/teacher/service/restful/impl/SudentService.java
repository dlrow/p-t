package com.pt.teacher.service.restful.impl;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.StudentDetailsDTO;
import com.pt.teacher.helper.util.Mapper;
import com.pt.teacher.model.ClassDetails;
import com.pt.teacher.model.StudentDetails;
import com.pt.teacher.repository.IClassRepository;
import com.pt.teacher.repository.IStudentRepository;
import com.pt.teacher.service.restful.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:-
 * This class implements all the services defined in IStudentService
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-01
 */
@Slf4j
@Service
public class SudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private IClassRepository classRepository;
    /**
     * This service will have logic for saving student to our System
     * @param studentDetailsDTO contains Student details
     * @return studentId of Student
     */
    public String addStudent(StudentDetailsDTO studentDetailsDTO)
    {
        log.info("Executing SudentService.addStudent() with param studentDetailsDTO:{}"+
                "which save student  to our System",studentDetailsDTO);
        StudentDetails studentDetails=mapper.mapStudentDetailsDTOToStudentDetails(studentDetailsDTO);
        StudentDetails returnedStudentDetails=studentRepository.save(studentDetails);
        log.debug("Saving saved student into its class");
        ClassDetails classDetails=classRepository.findByClassId(studentDetailsDTO.getClassId());
        List<String> studentOFClass=classDetails.getStudentIDs();
        if(studentOFClass==null) {
            studentOFClass=new ArrayList<String>();
        }
        studentOFClass.add(returnedStudentDetails.getStudentId());
        classDetails.setStudentIDs(studentOFClass);
        log.debug("Again saving the classDetails after student have been added");
        classRepository.save(classDetails);
        log.info("Returing studentId of the saved student from SudentService.addStudent()");
        return returnedStudentDetails.getStudentId();
    }

    @Override
    public StudentDetailsDTO getStudent(String studentId) {
        log.info("Executing SudentService.getStudent() with param studentId:{}"+
                "which fetch the student details from our System",studentId);
        StudentDetails returnedStudent=studentRepository.findByStudentId(studentId);
        StudentDetailsDTO studentDetailsDTO=mapper.mapStudentDetailsToStudentDetailsDTO(returnedStudent);
        log.info("Returning studentDetailsDTO obj which contains student details of the saved student from SudentService.getStudent()");
        return studentDetailsDTO;
    }

    @Override
    public String updateStudent(StudentDetailsDTO studentDetailsDTO) {
        log.info("Executing SudentService.updateStudent() with param studentDetailsDTO:{}"+
                "which will update the student details in our System",studentDetailsDTO);
        StudentDetails studentDetails=mapper.mapStudentDetailsDTOToStudentDetails(studentDetailsDTO);
        StudentDetails returnedStudent=studentRepository.save(studentDetails);
        log.info("eturing Success msg after updation in student details from SudentService.updateStudent()");
        return GeneralConstants.SUCCCESS_MSG;
    }

    @Override
    public String deleteStudent(String studentId) {
        log.info("Executing SudentService.deleteStudent() with param studentId:{}"+ "which will delete student details " +
                "from our System of given studentId",studentId);
        studentRepository.deleteByStudentId(studentId);
        log.debug("deleting student id from the class");
        ClassDetails classDetails=classRepository.findByClassId(studentId);
        List<String> studentOFClass=classDetails.getStudentIDs();
        studentOFClass.remove(studentId);
        classDetails.setStudentIDs(studentOFClass);
        log.debug("Again saving the classDetails after student have been deleted");
        classRepository.save(classDetails);
        log.info("Returing Success msg after deletion of student Details from SudentService.deleteStudent()");
        return GeneralConstants.SUCCCESS_MSG;
    }

    @Override
    public List<StudentDetailsDTO> getAllStudents(String classId)
    {
        log.info("Executing SudentService.getAllStudents() with param studentId:{}"+ "which will delete student details " +
                "from our System of given studentId",classId);
        List<StudentDetails> returnedlistOfSavedStudent=studentRepository.findByClassId(classId);
        List<StudentDetailsDTO> listOfStudentToSend=new ArrayList<>();
        for(StudentDetails student:returnedlistOfSavedStudent)
        {
            listOfStudentToSend.add(mapper.mapStudentDetailsToStudentDetailsDTO(student));
        }
        log.info("Returning list of student who belong to same class from SudentService.getAllStudents()");
        return listOfStudentToSend;
    }
}
