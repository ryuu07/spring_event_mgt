package com.AttendeeMngt.AttendeeManagement.Service;

import com.AttendeeMngt.AttendeeManagement.Entity.GuestList;
import com.AttendeeMngt.AttendeeManagement.Model.GuestListRequest;
import com.AttendeeMngt.AttendeeManagement.Model.GuestListResponse;
import com.AttendeeMngt.AttendeeManagement.Repository.GuestListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestListServiceImpl implements GuestListService {

    private final GuestListRepository guestListRepository;

    public GuestListServiceImpl(GuestListRepository guestListRepository) {
        this.guestListRepository = guestListRepository;
    }

    @Override
    public GuestListResponse createGuestList(GuestListRequest guestListRequest) {
        GuestList guestList = new GuestList();
        guestList.setName(guestListRequest.getName());
        guestList = guestListRepository.save(guestList);

        return new GuestListResponse(guestList.getId(), guestList.getName());
    }

    @Override
    public GuestListResponse getGuestListById(Long guestListId) {
        GuestList guestList = guestListRepository.findById(guestListId)
                .orElseThrow(() -> new RuntimeException("Guest list not found"));

        return new GuestListResponse(guestList.getId(), guestList.getName());
    }

    @Override
    public List<GuestListResponse> getAllGuestLists() {
        return guestListRepository.findAll().stream()
                .map(guestList -> new GuestListResponse(guestList.getId(), guestList.getName()))
                .collect(Collectors.toList());
    }
}

