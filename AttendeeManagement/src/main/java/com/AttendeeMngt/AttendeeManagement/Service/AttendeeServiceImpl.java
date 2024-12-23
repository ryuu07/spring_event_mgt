package com.AttendeeMngt.AttendeeManagement.Service;

import com.AttendeeMngt.AttendeeManagement.Entity.Attendee;
import com.AttendeeMngt.AttendeeManagement.Entity.GuestList;
import com.AttendeeMngt.AttendeeManagement.Model.AttendeeRequest;
import com.AttendeeMngt.AttendeeManagement.Model.AttendeeResponse;
import com.AttendeeMngt.AttendeeManagement.Repository.AttendeeRepository;
import com.AttendeeMngt.AttendeeManagement.Repository.GuestListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;
    private final GuestListRepository guestListRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository, GuestListRepository guestListRepository) {
        this.attendeeRepository = attendeeRepository;
        this.guestListRepository = guestListRepository;
    }

    @Override
    public AttendeeResponse createAttendee(AttendeeRequest attendeeRequest) {
        GuestList guestList = guestListRepository.findById(attendeeRequest.getGuestListId())
                .orElseThrow(() -> new RuntimeException("Guest list not found"));

        Attendee attendee = new Attendee();
        attendee.setName(attendeeRequest.getName());
        attendee.setEmail(attendeeRequest.getEmail());
        attendee.setGuestList(guestList);

        attendee = attendeeRepository.save(attendee);

        return new AttendeeResponse(attendee.getId(), attendee.getName(), attendee.getEmail(), guestList.getName());
    }

    @Override
    public AttendeeResponse getAttendeeById(Long attendeeId) {
        Attendee attendee = attendeeRepository.findById(attendeeId)
                .orElseThrow(() -> new RuntimeException("Attendee not found"));

        return new AttendeeResponse(attendee.getId(), attendee.getName(), attendee.getEmail(),
                attendee.getGuestList().getName());
    }

    @Override
    public List<AttendeeResponse> getAllAttendees() {
        return attendeeRepository.findAll().stream()
                .map(attendee -> new AttendeeResponse(attendee.getId(), attendee.getName(), attendee.getEmail(),
                        attendee.getGuestList().getName()))
                .collect(Collectors.toList());
    }
}
