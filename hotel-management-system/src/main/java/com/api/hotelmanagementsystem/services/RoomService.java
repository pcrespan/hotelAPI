package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.dto.RoomDTO;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(x -> new RoomDTO(x))
                .collect(Collectors.toList());
    }

    public RoomDTO findById(Long id) {
        return new RoomDTO(roomRepository.findById(id).get());
    }
}
