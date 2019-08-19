package com.pt.teacher.helper.dto;


import lombok.Data;

/**
 * Purpose:-This StudentDetailsDTO holds the details related to particular student which belong to some school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-01
 */
@Data
public class StudentDetailsDTO {

    /**
     * represent the student id
     */
    private String studentId;

    /**
     * represent the classId of class in which student study
     */
    private String classId;

    /**
     * represent the firstName of student
     */
    private String firstName;

    /**
     * represent the lastName of student
     */
    private String lastName;

    /**
     * represent the fatherName of student
     */
    private String fatherName;

    /**
     * represent the motherName of student
     */
    private String motherName;

    /**
     * represent the address of studemt
     */
    private String address;


    /**
     * represent the state in which student study
     */
    private String state;

    /**
     * represent the city in which student study
     */
    private String city;

    /**
     * represent the pincode in which student study
     */
    private String pincode;

    /**
     * represent the registered phoneNumber of parents
     */
    private String registeredPhoneNo;
}
