package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Sector;

public class SectorMinDTO {
    private Long id;
    private String name;
    private String description;

    public SectorMinDTO() {
    }

    public SectorMinDTO(Sector sector) {
        this.id = sector.getId();
        this.name = sector.getName();
        this.description = sector.getDescription();
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
}
