package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.dto.SectorDTO;
import com.api.hotelmanagementsystem.dto.SectorMinDTO;
import com.api.hotelmanagementsystem.entities.Sector;
import com.api.hotelmanagementsystem.services.SectorService;
import jakarta.servlet.Servlet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping
    public ResponseEntity<List<SectorMinDTO>> findAll() {
        List<SectorMinDTO> list = sectorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SectorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sectorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SectorDTO> insert(@Valid @RequestBody Sector sector) {
        SectorDTO sec = sectorService.insert(sector);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sec.getId())
                .toUri();

        return ResponseEntity.created(uri).body(sec);
    }
}
