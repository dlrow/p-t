package com.pt.teacher.model;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


/**
 * Purpose:-This class holds the details related to particular class in school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-27
 */

@Data
@Document(collection = "classdetails")
public class ClassDetails implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * represent the classId of the class
     */
    @Id
    private UUID classId;

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


}
