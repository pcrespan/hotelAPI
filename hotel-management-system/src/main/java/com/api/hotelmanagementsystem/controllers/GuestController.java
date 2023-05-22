package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> findAll() {
        return guestService.findAll();
    }

    @PostMapping(value = "/{id}")
    public Guest findById(@PathVariable long id) {
        return guestService.findById(id).get();
    }
}
