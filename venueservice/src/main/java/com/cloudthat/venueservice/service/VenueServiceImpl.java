package com.cloudthat.venueservice.service;

import com.cloudthat.venueservice.entity.Venue;
import com.cloudthat.venueservice.entity.VenueAvailability;
import com.cloudthat.venueservice.exception.ResourceNotFoundException;
import com.cloudthat.venueservice.model.VenueAvailabilityModel;
import com.cloudthat.venueservice.model.VenueModel;
import com.cloudthat.venueservice.repository.VenueAvailabilityRepository;
import com.cloudthat.venueservice.repository.VenueRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class VenueServiceImpl implements VenueService{
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private VenueAvailabilityRepository venueAvailabilityRepository;

    @Override
    public VenueModel createVenue(VenueModel venueModel) {
        Venue savedVenue = venueRepository.save(venueModelToVenue(venueModel));
        return venueToVenueModel(savedVenue);
    }

    @Override
    public VenueModel getVenue(Long venueId) {
        return venueRepository.findById(venueId)
                .map(this::venueToVenueModel)
                .orElseThrow(() -> new ResourceNotFoundException("Venue", "ID", venueId));
    }

    @Override
    public List<VenueModel> getAllVenues() {
        List<Venue> venueList = venueRepository.findAll();
        return venueList.stream()
                .map(this::venueToVenueModel).toList();
    }

    @Override
    public VenueModel updateVenue(Long venueId, VenueModel venueModel) {
        Venue venueDB = venueRepository.findById(venueId).get();

        if(Objects.nonNull(venueModel.getName()) && !("".equalsIgnoreCase(venueModel.getName()))){
            venueDB.setName(venueModel.getName());
        }

        if(Objects.nonNull(venueModel.getDescription()) && !("".equalsIgnoreCase(venueModel.getDescription()))){
            venueDB.setDescription(venueModel.getDescription());
        }

        if(Objects.nonNull(venueModel.getImageUrl()) && !("".equalsIgnoreCase(venueModel.getImageUrl()))){
            venueDB.setDescription(venueModel.getImageUrl());
        }


        venueRepository.save(venueDB);

        return venueToVenueModel(venueDB);
    }

    @Override
    public String deleteVenue(Long venueId) {
        Venue venue = venueRepository.findById(venueId).get();
        venueRepository.deleteById(venueId);
//        venue.setIsDeleted(true);
//        venueRepository.save(venue);
        return "Venue with id "+ venueId + " deleted successfully";
    }

    @Override
    public String bookVenue(Long venueId, VenueAvailabilityModel availabilityModel) {
        try {
            Venue venue = venueRepository.findById(venueId).get();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Venue","ID",venueId);
        }


        VenueAvailability venueAvailability = venueAvailabilityModelToVenueAvailability(availabilityModel);
        venueAvailability.setVenueId(venueId);

        venueAvailabilityRepository.save(venueAvailability);
        return "Venue booked successfully";
    }

    @Override
    public List<VenueAvailabilityModel> getBookedSlots(Long venueId, String date) {
        List<VenueAvailability> venueAvailabilities;
        if(date != null){
            return  venueAvailabilityRepository.findAllByVenueIdAndDate(venueId,date);
        }else{
            return  venueAvailabilityRepository.findAllByVenueId(venueId).stream()
                    .map(this::venueAvailabilityToVenueAvailabilityModel)
                    .toList();
        }
    }


    protected Venue venueModelToVenue(VenueModel venueModel){
        Venue venue = new Venue();
        venue.setId(venueModel.getId());
        venue.setName(venueModel.getName());
        venue.setDescription(venueModel.getDescription());
        venue.setCity(venueModel.getCity());
        venue.setState(venueModel.getState());
        venue.setZipcode(venueModel.getZipcode());
        venue.setAmenities(venueModel.getAmenities());
        venue.setCapacity(venueModel.getCapacity());
        venue.setImageUrl(venueModel.getImageUrl());


        return venue;
    }

    protected VenueModel venueToVenueModel(Venue venue){

        VenueModel venueModel = new VenueModel();
        venueModel.setId(venue.getId());
        venueModel.setName(venue.getName());
        venueModel.setDescription(venue.getDescription());
        venueModel.setCity(venue.getCity());
        venueModel.setState(venue.getState());
        venueModel.setZipcode(venue.getZipcode());
        venueModel.setAmenities(venue.getAmenities());
        venueModel.setCapacity(venue.getCapacity());
        venueModel.setImageUrl(venue.getImageUrl());

        return venueModel;
    }

    protected VenueAvailability venueAvailabilityModelToVenueAvailability(VenueAvailabilityModel venueAvailabilityModel){
        VenueAvailability venueAvailability = new VenueAvailability();
        venueAvailability.setId(venueAvailabilityModel.getId());
        venueAvailability.setVenueId(venueAvailabilityModel.getVenueId());
        venueAvailability.setStartDateTime(venueAvailabilityModel.getStartDateTime());
        venueAvailability.setEndDateTime(venueAvailabilityModel.getEndDateTime());
        venueAvailability.setIsAvailable(false);

        return venueAvailability;
    }
    protected VenueAvailabilityModel venueAvailabilityToVenueAvailabilityModel(VenueAvailability venueAvailability){
        VenueAvailabilityModel venueAvailabilityModel = new VenueAvailabilityModel();
        venueAvailabilityModel.setId(venueAvailability.getId());
        venueAvailabilityModel.setVenueId(venueAvailability.getVenueId());
        venueAvailabilityModel.setStartDateTime(venueAvailability.getStartDateTime());
        venueAvailabilityModel.setEndDateTime(venueAvailability.getEndDateTime());

        return venueAvailabilityModel;
    }
}
