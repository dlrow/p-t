package com.pt.teacher.model;


import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Purpose:-This class holds the details related to particular student
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-27
 */

@Data
@Document(collection = "studentdetails")
public class StudentDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * represent the student id which is formed by (phoneNo+studentFirstName);
     */
    private String studentId;

    /**
     * represent the firstName of Student
     */
    private String studentFirstName;

    /**
     * represent the lastName of Student
     */
    private String studentLastName;

    /**
     * represent the fatherName of Student
     */
    private String fatherName;

    /**
     * represent the MotherName of Student
     */
    private String motherName;

    /**
     * represent the address of Student
     */
    private String address;

    /**
     * represent the state in which his given address belongs
     */
    private String state;

    /**
     * represent the city in which his given address belongs
     */
    private String city;


    /**
     * represent the pincode in which his given address belongs
     */
    private String pincode;


    /**
     * represent the phone number of student's Father or Mother
     */
    private String phoneNo;

    /**
     * represent the classId of class to which a particular students belongs to
     */
    private String classId;
}
