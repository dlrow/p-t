package com.pt.teacher.service.restful.impl;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.ClassDetailsDTO;
import com.pt.teacher.helper.util.Mapper;
import com.pt.teacher.model.ClassDetails;
import com.pt.teacher.repository.IClassRepository;
import com.pt.teacher.repository.IStudentRepository;
import com.pt.teacher.service.restful.IClassService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class ClassService implements IClassService {

    private static final Logger Logger= LoggerFactory.getLogger(ClassService.class);
    @Autowired
    private IClassRepository classRepository;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    /**
     * This method will start saving class to our system
     * @param classDetailsDTO contains class detail
     * @return classId of the saved class
     */
    @Override
    public String addClass(ClassDetailsDTO classDetailsDTO)
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
    public ClassDetailsDTO getClass(String classid)
    {
        Logger.info("Executing ClassService.getClass() with param UUID:{}"+ "which will fetch class details from our System",classid);
        ClassDetails classDetails=classRepository.findByClassId(classid);
        ClassDetailsDTO classDetailsDTO=mapper.mapClassDetailsToClassDetailsDTO(classDetails);
        Logger.info("Returning classDetailsDTO obj which contains class details of the saved class from ClassService.getClass()");
        return classDetailsDTO;
    }

    /**
     * This method will the update the class details
     * @param classDetailsDTO represent the class details to be updated
     * @return Success Msg after updation
     */
    @Override
    public String updateClass(ClassDetailsDTO classDetailsDTO)
    {
        Logger.info("Executing ClassService.updateClass() with param classDetailsDTO:{}"+
                "which update the give class to our System",classDetailsDTO);
        ClassDetails classDetails=mapper.mapClassDetailsDtoToClassDetails(classDetailsDTO);
        ClassDetails returnedClassDetails=classRepository.save(classDetails);
        Logger.info("Returing Success msg after updation in class details from ClassService.updateClass()");
        return GeneralConstants.SUCCCESS_MSG;
    }


    /**
     * This method will delete the class details of given classId
     * @param classid repesent classid
     * @return Success Message after deleting the class
     */
    public String deleteClass(String classid)
    {
        Logger.info("Executing ClassService.deleteClass() with param UUID:{}"+ "which will delete class details " +
                "from our System of given classId",classid);
        classRepository.deleteByClassId(classid);
        log.info("Deleting all the students that belong to the class which we are going to delete");
        studentRepository.deleteByClassId(classid);
        Logger.info("Returing Success msg after deletion of classDetails from ClassService.deleteClass()");
        return GeneralConstants.SUCCCESS_MSG;
    }
}
