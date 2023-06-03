package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.dto.SectorDTO;
import com.api.hotelmanagementsystem.dto.SectorMinDTO;
import com.api.hotelmanagementsystem.entities.Sector;
import com.api.hotelmanagementsystem.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<SectorMinDTO> findAll() {
        return sectorRepository.findAll()
                .stream()
                .map(x -> new SectorMinDTO(x))
                .collect(Collectors.toList());
    }

    public SectorDTO findById(Long id) {
        return new SectorDTO(sectorRepository.findById(id).get());
    }

    public SectorDTO insert(Sector sector) {
        return new SectorDTO(sectorRepository.save(sector));
    }
}
