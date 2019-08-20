package com.pt.teacher.service.restful.impl;

import com.pt.teacher.helper.constant.GeneralConstants;
import com.pt.teacher.helper.dto.AttendenceDTO;
import com.pt.teacher.helper.dto.StudentDetailsDTO;
import com.pt.teacher.helper.util.Mapper;
import com.pt.teacher.helper.util.TodaysDate;
import com.pt.teacher.model.Attendence;
import com.pt.teacher.model.StudentDetails;
import com.pt.teacher.repository.IAttendenceRepository;
import com.pt.teacher.repository.IStudentRepository;
import com.pt.teacher.service.restful.IAttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendenceService implements IAttendenceService {

    @Autowired
    private TodaysDate todaysDate;

    @Autowired
    private IAttendenceRepository attendenceRepository;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    public String markAttendence(AttendenceDTO attendenceDTO,String classId)
    {
        LocalDate localDate=todaysDate.getTodaysDate();

        List<Attendence> studentsToBeMarked=attendenceRepository.findByClassId(classId);

        List<Attendence> studentsMarked=new ArrayList<>();

        for(Attendence attendence:studentsToBeMarked)
        {
            if(attendenceDTO.getStudentId().contains(attendence.getStudentId()))
            {
                List<LocalDate> dateOfAttendence=attendence.getDates();
                dateOfAttendence.add(localDate);
                studentsMarked.add(attendence);
            }
        }
        attendenceRepository.saveAll(studentsMarked);

       return GeneralConstants.SUCCCESS_MSG;
    }

    public List<StudentDetailsDTO> getUnMarkedStudent(String classId)
    {
        LocalDate localDate=todaysDate.getTodaysDate();
        List<Attendence> studentsToBeMarked=attendenceRepository.findByClassId(classId);
        List<String> studentsMarkedAbsent=new ArrayList<>();
        for(Attendence attendence:studentsToBeMarked)
        {
             if(!attendence.getDates().contains(localDate))
             {
                 studentsMarkedAbsent.add(attendence.getStudentId());
             }
        }
        List<StudentDetails> allStudent=studentRepository.findByClassId(classId);
        List<StudentDetailsDTO> listOfUnMarkedStudent=new ArrayList<>();
        for(StudentDetails student:allStudent)
        {
            if(studentsMarkedAbsent.contains(student.getStudentId()))
            {
                listOfUnMarkedStudent.add(mapper.mapStudentDetailsToStudentDetailsDTO(student));
            }
        }
        return listOfUnMarkedStudent;

    }

   public List<StudentDetailsDTO> getMarkedStudent(String classId)
   {
       LocalDate localDate=todaysDate.getTodaysDate();
       List<String> studentsMarkedPresent=new ArrayList<String>();
       List<Attendence> studentsToBeMarked=attendenceRepository.findByClassId(classId);
       for(Attendence attendence:studentsToBeMarked)
       {
           if(attendence.getDates().contains(localDate))
           {
               studentsMarkedPresent.add(attendence.getStudentId());
           }
       }
       List<StudentDetailsDTO> listOfMarkedStudent=new ArrayList<>();
       List<StudentDetails> allStudent=studentRepository.findByClassId(classId);
       for(StudentDetails student:allStudent)
       {
           if(studentsMarkedPresent.contains(student.getStudentId()))
           {
               listOfMarkedStudent.add(mapper.mapStudentDetailsToStudentDetailsDTO(student));
           }
       }
       return listOfMarkedStudent;
   }

}
