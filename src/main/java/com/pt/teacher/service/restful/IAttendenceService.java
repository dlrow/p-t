package com.pt.teacher.service.restful;

import com.pt.teacher.helper.dto.AttendenceDTO;
import com.pt.teacher.helper.dto.StudentDetailsDTO;
import com.pt.teacher.model.Attendence;

import java.util.List;

public interface IAttendenceService {

    String markAttendence(AttendenceDTO attendenceDTO, String classId);

    List<StudentDetailsDTO> getUnMarkedStudent(String classId);

    List<StudentDetailsDTO> getMarkedStudent(String classId);

    Attendence getAttendenceOfAStudent(String studentId);
}
