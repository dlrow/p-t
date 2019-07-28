package com.pt.teacher.service.restful.impl;

import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.helper.util.Mapper;
import com.pt.teacher.model.ClassDetails;
import com.pt.teacher.repository.IClassRepository;
import com.pt.teacher.service.restful.IClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * Purpose:-
 * This class implements all the services defined in IClassService
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 */
@Service
public class ClassService implements IClassService {

    private static final Logger Logger= LoggerFactory.getLogger(ClassService.class);
    @Autowired
    private IClassRepository classRepository;

    @Autowired
    private Mapper mapper;

    /**
     * This method will start saving class to our system
     * @param classDetailsDTO contains class detail
     * @return classId of the saved class
     */
    @Override
    public UUID addClass(ClassDetailsDTO classDetailsDTO)
    {
        Logger.info("Executing ClassService.addClass() with param classDetailsDTO:{}"+
                "which save the give class to our System",classDetailsDTO);
        ClassDetails classDetails=mapper.mapClassDetailsDtoToClassDetails(classDetailsDTO);
        ClassDetails returnedClassDetails=classRepository.save(classDetails);
        Logger.info("Returing ClassId of the saved class from ClassService.addClass()");
        return returnedClassDetails.getClassId();
    }


    /**
     * This method will fetch the class details from our System
     * @param classid represent classid
     * @return classDetailsDto which contains class details
     */
    @Override
    public ClassDetailsDTO getClass(UUID classid)
    {
        Logger.info("Executing ClassService.getClass() with param UUID:{}"+ "which will fetch class details from our System",classid);
        ClassDetails classDetails=classRepository.findByClassId(classid);
        ClassDetailsDTO classDetailsDTO=mapper.mapClassDetailsToClassDetailsDTO(classDetails);
        Logger.info("Returning classDetailsDTO obj which contains class details of the saved class from ClassService.getClass()");
        return classDetailsDTO;
    }
}
