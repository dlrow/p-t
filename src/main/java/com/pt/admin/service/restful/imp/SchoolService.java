package com.pt.admin.service.restful.imp;

import com.pt.admin.helper.constant.SchoolConstants;
import com.pt.admin.helper.dto.SchoolDTO;
import com.pt.admin.helper.util.SchoolMapper;
import com.pt.admin.model.SchoolDetails;
import com.pt.admin.repository.ISchoolRepository;
import com.pt.admin.service.restful.ISchoolService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Priyanshu Raj
 * @version 1.0
 * @Purpose
 * @since 2020-05-16
 **/


@Service
public class SchoolService implements ISchoolService {

    private static final org.slf4j.Logger Logger= LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private ISchoolRepository schoolRepository;


    @Override
    public String addSchool(SchoolDTO schoolDTO)
    {
        Logger.info("Executing SchoolService.addClass() with param schoolDTO:{}"+
                "which save the give school to our System",schoolDTO);
        SchoolDetails schoolDetails=schoolMapper.mapSchoolDtoToSchoolDetails(schoolDTO);
        SchoolDetails returnedSchoolDetails=schoolRepository.save(schoolDetails);
        Logger.info("Returing SchoolId of the saved school from SchoolService.addClass()");
        return returnedSchoolDetails.getSchoolId();
    }

    @Override
    public SchoolDTO getSchool(String schoolId){
        Logger.info("Executing SchoolService.getSchool() with param schoolID:{}"+ "which will fetch school details from our System",schoolId);
        SchoolDetails schoolDetails=schoolRepository.findBySchoolId(schoolId);
        SchoolDTO schoolDTO=schoolMapper.mapSchoolDetailsToSchoolDto(schoolDetails);
        Logger.info("Returning schoolDTO obj which contains school details of the saved school from schoolService.getSchool()");
        return schoolDTO;
    }


    @Override
    public String updateSchool(SchoolDTO schoolDTO){
        Logger.info("Executing SchoolService.updateSchool() with param SchoolDTO:{}"+
                "which update the give school to our System",schoolDTO);
        SchoolDetails schoolDetails=schoolMapper.mapSchoolDtoToSchoolDetails(schoolDTO);
        SchoolDetails returnedSchoolDetails=schoolRepository.save(schoolDetails);
        Logger.info("Returing Success msg after updation in school details from SchoolService.updateSchool()");
        return SchoolConstants.SUCCCESS_MSG;

    }


    @Override
    public String hardDeleteSchool(String schoolId){

        Logger.info("Executing SchoolService.hardDeleteSchool() with param schoolId:{} " +
                "which will delete school details from our System of given schoolId",schoolId);
        schoolRepository.deleteBySchoolId(schoolId);
        Logger.info("Returing Success msg after deletion of schoolDetails from SchoolService.hardDeleteSchool()");
        return SchoolConstants.SUCCCESS_MSG;

    }

    @Override
    public String softDeleteSchool(String schoolId){
        Logger.info("Executing SchoolService.softDeleteSchool() with param schoolId:{} " +
                "which will delete school details from our System of given schoolId",schoolId);
        SchoolDetails schoolDetails=schoolRepository.findBySchoolId(schoolId);
        schoolDetails.setIsSchoolDeleted(true);
        schoolRepository.save(schoolDetails);
        Logger.info("Returing Success msg after deletion of schoolDetails from SchoolService.softDeleteSchool()");
        return SchoolConstants.SUCCCESS_MSG;

    }
}
