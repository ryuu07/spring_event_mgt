package com.AttendeeMngt.AttendeeManagement.Service;

import com.AttendeeMngt.AttendeeManagement.Model.AttendeeRequest;
import com.AttendeeMngt.AttendeeManagement.Model.AttendeeResponse;

import java.util.List;

public interface AttendeeService {
    AttendeeResponse createAttendee(AttendeeRequest attendeeRequest);

    AttendeeResponse getAttendeeById(Long attendeeId);

    List<AttendeeResponse> getAllAttendees();
}

