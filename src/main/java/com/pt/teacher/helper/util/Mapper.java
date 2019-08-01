package com.pt.teacher.helper.util;

import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.model.ClassDetails;
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
    public ClassDetails mapClassDetailsDtoToClassDetails(ClassDetailsDTO classDetailsDTO, UUID uuid)
    {
        Logger.info("Executing Mapper.mapClassDetailsDtoToClassDetails() with param classDetailsDTO:{}"+
                "which convert DTO to classDetails Entity",classDetailsDTO);
        ClassDetails classDetails=new ClassDetails();
        if(uuid==null) {
            classDetails.setClassId(uuidGenerator.getUuid());
        }
        else
        {
            classDetails.setClassId(uuid);
        }
        classDetails.setMonitorName(classDetailsDTO.getMonitorName());
        classDetails.setClassName(classDetailsDTO.getClassName());
        classDetails.setSection(classDetailsDTO.getSection());
        classDetails.setSubject(classDetailsDTO.getSubject());
        classDetails.setTimeTable(classDetailsDTO.getTimeTable());
        Logger.info("Sending Class Details Entity object to ClassService from Mapper.mapClassDetailsDtoToClassDetails()");
        return classDetails;
    }

    public ClassDetailsDTO mapClassDetailsToClassDetailsDTO(ClassDetails classDetails)
    {
        Logger.info("Executing Mapper.mapClassDetailsToClassDetailsDTO() with param classDetails:{}"+
                "which classDetails Entity to convert classDetailsDTO ",classDetails);
        ClassDetailsDTO classDetailsDTO=new ClassDetailsDTO();
        classDetailsDTO.setClassId(classDetails.getClassId());
        classDetailsDTO.setClassName(classDetails.getClassName());
        classDetailsDTO.setMonitorName(classDetails.getMonitorName());
        classDetailsDTO.setSection(classDetails.getSection());
        classDetailsDTO.setSubject(classDetails.getSubject());
        classDetailsDTO.setTimeTable(classDetails.getTimeTable());
        Logger.info("Sending ClassDetailsDTO to classService from Mapper.mapClassDetailsToClassDetailsDTO()");
        return classDetailsDTO;
    }

}
