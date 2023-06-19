package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.dto.GuestDTO;
import com.api.hotelmanagementsystem.dto.GuestMinDTO;
import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.StayRequest;
import com.api.hotelmanagementsystem.services.GuestService;
import com.api.hotelmanagementsystem.services.StayService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
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
    public ResponseEntity<GuestDTO> insert(@Valid @RequestBody Guest guest) {
        GuestDTO obj = new GuestDTO(guestService.insert(guest));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping(value = "/{id}/stay")
    public List<Stay> findStayByGuestId(@PathVariable long id) {
        return guestService.findById(id).getStay();
    }

    @PostMapping(value = "/{id}/stay")
    public Stay insertStay(@PathVariable long id, @Valid @RequestBody StayRequest stay) {
        stay.setGuestId(id);
        return stayService.insert(stay);
    }
}
