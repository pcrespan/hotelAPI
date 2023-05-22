package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> findAll() {
        return ResponseEntity.ok().body(roomService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(roomService.findById(id).get());
    }
}
