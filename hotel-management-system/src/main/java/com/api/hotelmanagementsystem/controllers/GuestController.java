package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import com.api.hotelmanagementsystem.services.GuestService;
import com.api.hotelmanagementsystem.services.RoomService;
import com.api.hotelmanagementsystem.services.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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

    @PostMapping
    public ResponseEntity<Guest> insert(@RequestBody Guest guest, Long roomId, Date arrival, Date leaving) {
        Guest obj = guestService.insert(guest, roomId, arrival, leaving);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }
}
