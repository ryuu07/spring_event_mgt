package com.cloudthat.eventservice.model;



import com.cloudthat.eventservice.entity.Category;
import com.cloudthat.eventservice.entity.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {
    private Long id;
    private String name;
    private String description;
    private Instant startDateTime;
    private Instant endDateTime;
    private Long venueId;
    private Long organizerId;
    private EventStatus eventStatus;
    private Set<Long> categoryIds;
}
