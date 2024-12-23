package com.AttendeeMngt.AttendeeManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeResponse {
    private Long id;
    private String name;
    private String email;
    private String guestListName;

    public AttendeeResponse(Long id, String name, String email, String guestListName) {
    }
}
