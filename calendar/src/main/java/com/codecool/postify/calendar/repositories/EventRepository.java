package com.codecool.postify.calendar.repositories;

import com.codecool.postify.calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EventRepository extends JpaRepository <Event, Long> {
}
