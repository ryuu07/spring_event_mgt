package com.AttendeeMngt.AttendeeManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeRequest {
    private String name;
    private String email;
    private Long guestListId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getGuestListId() {
        return guestListId;
    }

    public void setGuestListId(Long guestListId) {
        this.guestListId = guestListId;
    }
}
