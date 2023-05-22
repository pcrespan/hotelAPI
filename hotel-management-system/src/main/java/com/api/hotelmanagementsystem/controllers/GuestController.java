package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<Guest>> findAll() {
        return ResponseEntity.ok().body(guestService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Guest> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(guestService.findById(id).get());
    }
}
