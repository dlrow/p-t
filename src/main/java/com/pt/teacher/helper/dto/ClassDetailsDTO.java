package com.pt.teacher.helper.dto;


import lombok.Data;

import java.util.List;

/**
 * Purpose:-This classDTO holds the details related to particular class in school
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 */

@Data
public class ClassDetailsDTO {

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

