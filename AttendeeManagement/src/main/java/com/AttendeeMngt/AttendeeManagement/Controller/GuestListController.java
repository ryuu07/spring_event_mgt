package com.AttendeeMngt.AttendeeManagement.Controller;

import com.AttendeeMngt.AttendeeManagement.Model.ApiResponse;
import com.AttendeeMngt.AttendeeManagement.Model.GuestListRequest;
import com.AttendeeMngt.AttendeeManagement.Model.GuestListResponse;
import com.AttendeeMngt.AttendeeManagement.Service.GuestListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/guestlists")
public class GuestListController {

    private final GuestListService guestListService;

    public GuestListController(GuestListService guestListService) {
        this.guestListService = guestListService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<GuestListResponse>> createGuestList(@RequestBody GuestListRequest guestListRequest) {
        GuestListResponse guestListResponse = guestListService.createGuestList(guestListRequest);
        return new ResponseEntity<>(new ApiResponse<>(true, "Guest list created successfully", guestListResponse), HttpStatus.CREATED);
    }

    @GetMapping("/{guestListId}")
    public ResponseEntity<ApiResponse<GuestListResponse>> getGuestList(@PathVariable Long guestListId) {
        GuestListResponse guestListResponse = guestListService.getGuestListById(guestListId);
        return new ResponseEntity<>(new ApiResponse<>(true, "Guest list fetched successfully", guestListResponse), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GuestListResponse>>> getAllGuestLists() {
        List<GuestListResponse> guestLists = guestListService.getAllGuestLists();
        return new ResponseEntity<>(new ApiResponse<>(true, "Guest lists fetched successfully", guestLists), HttpStatus.OK);
    }
}
