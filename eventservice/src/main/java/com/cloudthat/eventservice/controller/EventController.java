package com.cloudthat.eventservice.controller;

import com.cloudthat.eventservice.model.ApiResponse;
import com.cloudthat.eventservice.model.EventModel;
import com.cloudthat.eventservice.model.EventResponse;
import com.cloudthat.eventservice.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private static final Log log = LogFactory.getLog(EventController.class);
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<ApiResponse> createEvent(@RequestBody EventModel eventModel){
        EventModel eventModel1 = eventService.createEvent(eventModel);
        return new ResponseEntity<>(new ApiResponse(true, "Event Created Succesfully", eventModel1), HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<ApiResponse> getEvent(@PathVariable("eventId") Long eventId){
        EventModel eventModel1 = eventService.getEvent(eventId);
        return new ResponseEntity<>(new ApiResponse(true, "Event Fetched Succesfully", eventModel1), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllEvents(){
        List<EventModel> events = eventService.getAllEvents();
        return new ResponseEntity<>(new ApiResponse(true, "All Events Fetched Succesfully", events), HttpStatus.OK);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<ApiResponse> updateEvent(@PathVariable("eventId") Long eventId, @RequestBody EventModel eventModel){
        EventModel updatedEvent = eventService.updateEvent(eventId,eventModel);
        return new ResponseEntity<>(new ApiResponse(true, "Event updated Succesfully", updatedEvent), HttpStatus.OK);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<ApiResponse> deleteEvent(@PathVariable("eventId") Long eventId){
        String deleteMessage = eventService.deleteEvent(eventId);
        return new ResponseEntity<>(new ApiResponse(true, "Event deleted Succesfully", deleteMessage), HttpStatus.OK);
    }

    @GetMapping("/{eventId}/details")
    public ResponseEntity<ApiResponse> getEventDetails(@PathVariable("eventId") Long eventId){
        EventResponse eventModel1 = eventService.getEventDetails(eventId);
        return new ResponseEntity<>(new ApiResponse(true, "Event Fetched Succesfully", eventModel1), HttpStatus.OK);
    }

}
