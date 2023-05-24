package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import com.api.hotelmanagementsystem.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private StayService stayService;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest insert(Guest guest, Long roomId, Date arrival, Date leaving) {
        Room room = roomService.findById(roomId).get();

        if (room.isFree()) {
            guestRepository.save(guest);
            room.setStatus(RoomStatus.OCCUPIED);
            stayService.insert(guest, room, arrival, leaving);
            return guest;
        }
        throw new IllegalArgumentException();
    }
}
