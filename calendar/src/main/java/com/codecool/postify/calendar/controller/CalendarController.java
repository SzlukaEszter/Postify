package com.codecool.postify.calendar.controller;

import com.codecool.postify.calendar.model.Week;
import com.codecool.postify.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("/week/{startDate}")
    public Week getWeekStartsWith(@PathVariable LocalDate startDate) throws Exception {
            return calendarService.getWeek(startDate);
    }
}
