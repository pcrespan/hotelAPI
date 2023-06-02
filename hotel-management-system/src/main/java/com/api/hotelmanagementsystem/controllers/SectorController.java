package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.dto.SectorDTO;
import com.api.hotelmanagementsystem.dto.SectorMinDTO;
import com.api.hotelmanagementsystem.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
