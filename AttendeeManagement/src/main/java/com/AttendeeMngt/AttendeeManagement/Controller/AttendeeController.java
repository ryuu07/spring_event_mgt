package com.AttendeeMngt.AttendeeManagement.Controller;

import com.AttendeeMngt.AttendeeManagement.Model.ApiResponse;
import com.AttendeeMngt.AttendeeManagement.Model.AttendeeRequest;
import com.AttendeeMngt.AttendeeManagement.Model.AttendeeResponse;
import com.AttendeeMngt.AttendeeManagement.Service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendeeResponse>> createAttendee(@RequestBody AttendeeRequest attendeeRequest) {
        AttendeeResponse attendeeResponse = attendeeService.createAttendee(attendeeRequest);
        return new ResponseEntity<>(new ApiResponse<>(true, "Attendee created successfully", attendeeResponse), HttpStatus.CREATED);
    }

    @GetMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<AttendeeResponse>> getAttendee(@PathVariable Long attendeeId) {
        AttendeeResponse attendeeResponse = attendeeService.getAttendeeById(attendeeId);
        return new ResponseEntity<>(new ApiResponse<>(true, "Attendee fetched successfully", attendeeResponse), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendeeResponse>>> getAllAttendees() {
        List<AttendeeResponse> attendees = attendeeService.getAllAttendees();
        return new ResponseEntity<>(new ApiResponse<>(true, "Attendees fetched successfully", attendees), HttpStatus.OK);
    }
}
