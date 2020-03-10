package com.codecool.postify.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {

    private long id;

    private String title;

    private String lead;

    private String body;

    private String mediaUrl;

    private List<String> hashtags;

    private long eventId;
}
