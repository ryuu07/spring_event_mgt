package com.cloudthat.eventservice.service;

import com.cloudthat.eventservice.model.EventModel;
import com.cloudthat.eventservice.model.EventResponse;

import java.util.List;

public interface EventService {
    EventModel createEvent(EventModel eventModel);

    EventModel getEvent(Long eventId);

    List<EventModel> getAllEvents();

    EventModel updateEvent(Long eventId, EventModel eventModel);

    String deleteEvent(Long eventId);

    EventResponse getEventDetails(Long eventId);
}
