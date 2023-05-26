package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.dto.GuestMinDTO;
import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.services.GuestService;
import com.api.hotelmanagementsystem.services.StayService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private StayService stayService;

    @GetMapping
    public ResponseEntity<List<GuestMinDTO>> findAll() {
        return ResponseEntity.ok().body(guestService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GuestMinDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(guestService.findGuestMinById(id));
    }

    @PostMapping
    public ResponseEntity<Guest> insert(@RequestBody Guest guest) {
        Guest obj = guestService.insert(guest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping(value = "/{id}/stay")
    public Set<Stay> findStayByGuestId(@PathVariable long id) {
        return guestService.findById(id).getStay();
    }

    @PostMapping(value = "/{id}/stay")
    public Stay insertStay(@PathVariable long id, @RequestBody Stay stay) {
        Guest guest = guestService.findById(id);
        stay.setGuest(guest);
        return stayService.insert(stay);
    }
}
