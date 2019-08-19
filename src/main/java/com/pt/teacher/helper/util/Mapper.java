package com.pt.teacher.helper.util;

import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.helper.dto.StudentDetailsDTO;
import com.pt.teacher.model.ClassDetails;
import com.pt.teacher.model.StudentDetails;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Purpose:-This is a general purpose class used for mapping one type of object to another type of object
 *          as per business use cases.
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-06
 */
@Slf4j
@Component
public class Mapper {

    private static final Logger Logger = LoggerFactory.getLogger(Mapper.class);

    @Autowired
    private UuidGenerator uuidGenerator;
    /**
     * This function will convert given param to ClassDetails
     * @param classDetailsDTO represent the class details DTO
     * @return classDetails Entity
     */
    public ClassDetails mapClassDetailsDtoToClassDetails(ClassDetailsDTO classDetailsDTO, String classId)
    {
        Logger.info("Executing Mapper.mapClassDetailsDtoToClassDetails() with param classDetailsDTO:{}"+
                "which convert DTO to classDetails Entity",classDetailsDTO);
        ClassDetails classDetails=new ClassDetails();
        if(classId==null) {
            classDetails.setClassId("123");
        }
        else
        {
            classDetails.setClassId(classId);
        }
        classDetails.setSchoolId(classDetailsDTO.getSchoolId());
        classDetails.setMonitorName(classDetailsDTO.getMonitorName());
        classDetails.setClassName(classDetailsDTO.getClassName());
        classDetails.setSection(classDetailsDTO.getSection());
        classDetails.setSubject(classDetailsDTO.getSubject());
        classDetails.setTimeTable(classDetailsDTO.getTimeTable());
        Logger.info("Sending Class Details Entity object to ClassService from Mapper.mapClassDetailsDtoToClassDetails()");
        return classDetails;
    }

    /**
     * This function will convert given param to ClassDetailsDTO
     * @param classDetails represent the class details returned from our System
     * @return ClassDetailsDTO
     */
    public ClassDetailsDTO mapClassDetailsToClassDetailsDTO(ClassDetails classDetails)
    {
        Logger.info("Executing Mapper.mapClassDetailsToClassDetailsDTO() with param classDetails:{}"+
                "which converts classDetails Entity to classDetailsDTO ",classDetails);
        ClassDetailsDTO classDetailsDTO=new ClassDetailsDTO();
        classDetailsDTO.setSchoolId(classDetails.getSchoolId());
        classDetailsDTO.setClassId(classDetails.getClassId());
        classDetailsDTO.setClassName(classDetails.getClassName());
        classDetailsDTO.setMonitorName(classDetails.getMonitorName());
        classDetailsDTO.setSection(classDetails.getSection());
        classDetailsDTO.setSubject(classDetails.getSubject());
        classDetailsDTO.setTimeTable(classDetails.getTimeTable());
        Logger.info("Sending ClassDetailsDTO to classService from Mapper.mapClassDetailsToClassDetailsDTO()");
        return classDetailsDTO;
    }

    /**
     * This function will convert studentDetails Entity to StudentDetailsDto
     * @param studentDetails represent the student details returned from our System
     * @return StudentDetailsDTo
     */
    public StudentDetailsDTO mapStudentDetailsToStudentDetailsDTO(StudentDetails studentDetails)
    {
        log.info("Executing Mapper.mapStudentDetailsToStudentDetailsDTO() with param studentDetails:{}"+
                "which converts StudentDetails Entity to  StudentDetails ",studentDetails);
        StudentDetailsDTO studentDetailsDTO=new StudentDetailsDTO();
        studentDetailsDTO.setStudentId(studentDetails.getStudentId());
        studentDetailsDTO.setClassId(studentDetails.getClassId());
        studentDetailsDTO.setFirstName(studentDetails.getFirstName());
        studentDetailsDTO.setLastName(studentDetails.getLastName());
        studentDetailsDTO.setFatherName(studentDetails.getFatherName());
        studentDetailsDTO.setMotherName(studentDetails.getMotherName());
        studentDetailsDTO.setAddress(studentDetails.getAddress());
        studentDetailsDTO.setState(studentDetails.getState());
        studentDetailsDTO.setCity(studentDetails.getCity());
        studentDetailsDTO.setPincode(studentDetails.getPincode());
        studentDetailsDTO.setRegisteredPhoneNo(studentDetails.getRegisteredPhoneNo());
        log.info("Sending StudentDetailsDTO to studentService from Mapper.mapStudentDetailsToStudentDetailsDTO()");
        return studentDetailsDTO;
    }

    /**
     * This function will convert studentDetails Entity to StudentDetailsDto
     * @param studentDetailsDTO represent the student details returned from our System
     * @return StudentDetailsDTo
     */
    public StudentDetails mapStudentDetailsDTOToStudentDetails(StudentDetailsDTO studentDetailsDTO)
    {
        log.info("Executing Mapper.mapStudentDetailsDTOToStudentDetails() with param studentDetailsDTO:{}"+
                "which converts StudentDetails to sudentDetails Entity  ",studentDetailsDTO);
        StudentDetails studentDetails=new StudentDetails();
        studentDetails.setClassId(studentDetailsDTO.getClassId());
        studentDetails.setStudentId(studentDetailsDTO.getStudentId());
        studentDetails.setFirstName(studentDetailsDTO.getFirstName());
        studentDetails.setCity(studentDetailsDTO.getCity());
        studentDetails.setLastName(studentDetailsDTO.getLastName());
        studentDetails.setFatherName(studentDetailsDTO.getFatherName());
        studentDetails.setAddress(studentDetailsDTO.getAddress());
        studentDetails.setState(studentDetailsDTO.getState());
        studentDetails.setMotherName(studentDetailsDTO.getMotherName());
        studentDetails.setPincode(studentDetailsDTO.getPincode());
        studentDetails.setRegisteredPhoneNo(studentDetailsDTO.getRegisteredPhoneNo());
        log.info("Sending studentDetails to studentService from Mapper.mapStudentDetailsDTOToStudentDetails()");
        return studentDetails;
    }

}
