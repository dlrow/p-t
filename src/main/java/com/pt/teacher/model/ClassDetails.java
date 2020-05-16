package com.pt.teacher.model;


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Purpose:-This class holds the details related to particular class in school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-27
 */

//TODO : add List<student> the class has
@Data
@Document(collection = "classdetails")
public class ClassDetails implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * represent the classId of the class
     */
    @Id
    @Field("_id")
    private String classId;

    /**
     * represent the schoolId to which this class belongs
     */
    private String schoolId;

    /**
     * represent the Name of class
     */
    private String className;

    /**
     * represent the section of class
     */
    private String section;

    /**
     * represent the name of class's monitor
     */
    private String monitorName;

    /**
     * represent the List of Subject taught in the class
     */
    private List<String> subject;

    /**
     * represent the time table of class
     */
    private List<List<String>> timeTable;

    /**
     * represent the list of studentID belong to this class
     */
    private List<String> studentIDs;

    /**
     * represent the class teacher and teacher that have access of given class
     */
    private Map<String,String> teacherIds;

}
