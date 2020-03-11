package com.codecool.postify.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate date;

    private LocalTime time;

    private long contentId;

    @ElementCollection(targetClass = Channel.class)
    @Enumerated(EnumType.STRING)
    private Set<Channel> channels;


}
