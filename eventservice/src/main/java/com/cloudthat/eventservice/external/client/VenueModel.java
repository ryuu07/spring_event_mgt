package com.cloudthat.eventservice.external.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueModel implements Serializable {
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
