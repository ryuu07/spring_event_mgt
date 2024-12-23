package com.cloudthat.eventservice.model;

import com.cloudthat.eventservice.entity.EventStatus;
import com.cloudthat.eventservice.external.client.VenueModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Long id;
    private String name;
    private String description;
    private Instant startDateTime;
    private Instant endDateTime;
    private VenueModel venue;
    private Long organizerId;
    private EventStatus eventStatus;
    private Set<CategoryModel> categories;
}
