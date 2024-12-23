package com.AttendeeMngt.AttendeeManagement.Service;

import com.AttendeeMngt.AttendeeManagement.Model.GuestListRequest;
import com.AttendeeMngt.AttendeeManagement.Model.GuestListResponse;

import java.util.List;

public interface GuestListService {
    GuestListResponse createGuestList(GuestListRequest guestListRequest);

    GuestListResponse getGuestListById(Long guestListId);

    List<GuestListResponse> getAllGuestLists();
}
