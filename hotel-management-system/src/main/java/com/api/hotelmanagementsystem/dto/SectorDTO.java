package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.Sector;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

public class SectorDTO {

    private Long id;
    private String name;
    private String description;
    private Set<Contract> contracts = new HashSet<>();

    public SectorDTO() {
    }

    public SectorDTO(Sector sector) {
        BeanUtils.copyProperties(sector, this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }
}
