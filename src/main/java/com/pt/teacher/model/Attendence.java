package com.pt.teacher.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Attendence {


    private String classId;

    @Id
    private String studentId;

    private List<LocalDate>  dates;
}
