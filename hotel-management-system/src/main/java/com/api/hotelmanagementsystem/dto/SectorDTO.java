package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.Sector;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SectorDTO {

    private Long id;
    private String name;
    private String description;
    private Set<ContractMinDTO> contracts = new HashSet<>();

    public SectorDTO() {
    }

    public SectorDTO(Sector sector) {
        this.id = sector.getId();
        this.name = sector.getName();
        this.description = sector.getDescription();
        this.contracts = convertContracts(sector.getContracts());
    }

    private Set<ContractMinDTO> convertContracts(Set<Contract> previousContracts) {
        Set<ContractMinDTO> convertedContracts = previousContracts
                .stream()
                .map(x -> new ContractMinDTO(x))
                .collect(Collectors.toSet());
        return convertedContracts;
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

    public Set<ContractMinDTO> getContracts() {
        return contracts;
    }
}
