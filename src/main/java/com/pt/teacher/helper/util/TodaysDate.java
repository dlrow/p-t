package com.pt.teacher.helper.util;


import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import org.springframework.stereotype.Component;


/**
 * Purpose:-This is a general purpose class used for getting today's date
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-08-19
 */
@Slf4j
@Component
public class TodaysDate {

    public LocalDate getTodaysDate()
    {
        LocalDate localDate = LocalDate.now();

        return localDate;
    }
}
