package com.pt.teacher.model;


import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Purpose:-This class holds the details related to particular student
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-01
 */

@Data
@Document(collection = "studentdetails")
public class StudentDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * represent the student id
     */
    @Id
    @Field("_id")
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
