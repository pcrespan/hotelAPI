package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.Guest;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

public class GuestDTO {
    private Long id;
    private String name;
    private String socialSecurityNumber;

    private Set<Stay> stay = new HashSet<>();

    public GuestDTO() {
    }

    public GuestDTO(Guest guest) {
        BeanUtils.copyProperties(guest, this);
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

    public Set<Stay> getStay() {
        return stay;
    }
}
