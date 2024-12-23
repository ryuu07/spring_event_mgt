package com.AttendeeMngt.AttendeeManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestListResponse {
    private Long id;
    private String name;

    public GuestListResponse(Long id, String name) {
    }
}
