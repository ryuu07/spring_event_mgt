package com.cloudthat.venueservice.service;

import com.cloudthat.venueservice.model.VenueAvailabilityModel;
import com.cloudthat.venueservice.model.VenueModel;

import java.util.List;

public interface VenueService {
    VenueModel createVenue(VenueModel venueModel);

    VenueModel getVenue(Long venueId);

    List<VenueModel> getAllVenues();

    VenueModel updateVenue(Long venueId, VenueModel venueModel);

    String deleteVenue(Long venueId);

    String bookVenue(Long venueId, VenueAvailabilityModel availabilityModel);

    List<VenueAvailabilityModel> getBookedSlots(Long venueId, String date);
}
