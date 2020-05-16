package com.pt.teacher.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "attendencedetails")
public class Attendence {


    private String classId;

    @Id
    @Field("_id")
    private String studentId;

    private List<LocalDate>  dates;
}
