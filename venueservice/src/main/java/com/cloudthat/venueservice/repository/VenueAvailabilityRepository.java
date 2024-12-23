package com.cloudthat.venueservice.repository;

import com.cloudthat.venueservice.entity.VenueAvailability;
import com.cloudthat.venueservice.model.VenueAvailabilityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueAvailabilityRepository extends JpaRepository<VenueAvailability, Long> {
    List<VenueAvailability> findAllByVenueId(Long venueId);

    @Query(value = "SELECT id, e.name, e.start_date_time, e.end_date_time"+
            " FROM venue_availability e WHERE e.venue_id = :venueId AND DATE(e.start_date_time AT TIME ZONE 'UTC') = :date", nativeQuery = true)
    List<VenueAvailabilityModel> findAllByVenueIdAndDate(Long venueId, String date);


}
