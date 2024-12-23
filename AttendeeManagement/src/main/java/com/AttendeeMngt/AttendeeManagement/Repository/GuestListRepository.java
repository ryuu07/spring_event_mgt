package com.AttendeeMngt.AttendeeManagement.Repository;

import com.AttendeeMngt.AttendeeManagement.Entity.GuestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestListRepository extends JpaRepository<GuestList, Long> {
}

