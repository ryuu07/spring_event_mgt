package com.cloudthat.eventservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;


import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "events")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_name")
    @Length(min=3, max=30)
    @NotBlank
    private String name;
    @Column(name = "event_description")
    private String description;
    @Column(name = "start_date_time")
    private Instant startDateTime;
    @Column(name = "end_date_time")
    private Instant endDateTime;
    @Column(name = "event_venue")
    private Long venueId;
    @Column(name = "event_organizer")
    private Long organizerId;

    @Enumerated
    private EventStatus eventStatus;

    //unidirectional many to many mapping
    @ManyToMany
    @JoinTable(
            name = "event_category", // Name of the intermediary table
            joinColumns = @JoinColumn(name = "event_id"), // Foreign key for Event
            inverseJoinColumns = @JoinColumn(name = "category_id") // Foreign key for Category
    )
    private Set<Category> categories = new HashSet<>();

//    @Convert(converter = TrueFalseConverter.class)
//    private Boolean isDeleted = false;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
