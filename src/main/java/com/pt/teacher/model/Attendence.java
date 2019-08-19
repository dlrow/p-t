package com.pt.teacher.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Attendence {


    private String classId;

    @Id
    private String studentId;

    private Date date;
}
