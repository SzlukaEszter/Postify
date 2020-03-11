package com.codecool.postify.calendar.service;

import com.codecool.postify.calendar.model.Day;
import com.codecool.postify.calendar.model.Event;
import com.codecool.postify.calendar.model.Week;
import com.codecool.postify.calendar.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CalendarService {

    @Autowired
    EventRepository eventRepository;

    public Week getWeek(LocalDate startDate){

        while (!startDate.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            startDate = startDate.minusDays(1);
        }
        Day[] days = new Day [7];
        for (int i = 0; i < 7; i++) {

        days[i] = (getDay(startDate));
        startDate = startDate.plusDays(1);
        }

       return Week.builder()
                    .days(Arrays.asList(days))
                    .build();
    }

    public Day getDay(LocalDate date){
        return Day.builder()
                .date(date)
                .events(eventRepository.findEventsByDate(date))
                .build();

    }


}
