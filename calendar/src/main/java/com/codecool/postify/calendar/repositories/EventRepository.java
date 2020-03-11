package com.codecool.postify.calendar.repositories;

import com.codecool.postify.calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface EventRepository extends JpaRepository <Event, Long> {
    public List<Event> findEventsByDate(LocalDate date);
}
