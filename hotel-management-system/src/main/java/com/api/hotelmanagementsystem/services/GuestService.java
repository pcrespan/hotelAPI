package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.dto.GuestMinDTO;
import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import com.api.hotelmanagementsystem.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<GuestMinDTO> findAll() {
        List<Guest> list = guestRepository.findAll();
        return list.stream().map(x -> new GuestMinDTO(x)).collect(Collectors.toList());
    }

    public Guest findById(Long id) {
        return guestRepository.findById(id).get();
    }

    public GuestMinDTO findGuestMinById(Long id) {
        Guest guest = guestRepository.findById(id).get();
        return new GuestMinDTO(guest);
    }

    public Guest insert(Guest guest) {
        return guestRepository.save(guest);
    }
}
