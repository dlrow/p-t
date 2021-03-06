package com.pt.teacher.helper.dto;


import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Purpose:-This classDTO holds the details related to particular class in school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 */
//TODO add List<Student>
@Data
public class ClassDetailsDTO {

    /**
     * represent the class id of the class
     */
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

