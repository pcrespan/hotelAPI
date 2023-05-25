package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Guest;

public class GuestMinDTO {
    private Long id;
    private String name;
    private String socialSecurityNumber;

    public GuestMinDTO() {
    }

    public GuestMinDTO(Guest guest) {
        this.id = guest.getId();
        this.name = guest.getName();
        this.socialSecurityNumber = guest.getSocialSecurityNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}
