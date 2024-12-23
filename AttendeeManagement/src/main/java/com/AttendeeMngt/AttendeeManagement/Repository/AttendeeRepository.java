package com.AttendeeMngt.AttendeeManagement.Repository;

import com.AttendeeMngt.AttendeeManagement.Entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}

