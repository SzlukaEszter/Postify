package com.codecool.postify.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {

    private LocalDate date;

    private List<Event> events = new ArrayList<>();

    public void add(Event event){
        events.add(event);
    }
}
