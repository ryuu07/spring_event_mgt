package com.cloudthat.venueservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueModel {
    private Long id;
    private String name;
    private String city;
    private String state;
    private String zipcode;
    private String amenities;
    private Integer capacity;

    private String description;
    private String imageUrl;

}
