package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.StayRequest;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import com.api.hotelmanagementsystem.repositories.GuestRepository;
import com.api.hotelmanagementsystem.repositories.RoomRepository;
import com.api.hotelmanagementsystem.repositories.StayRepository;
import com.api.hotelmanagementsystem.services.exceptions.InvalidRoomIdException;
import com.api.hotelmanagementsystem.services.exceptions.RoomOccupiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    GuestRepository guestRepository;

    @Transactional
    public Stay insert(StayRequest stayRequest) {

        try {
            Room room = roomRepository.findById(stayRequest.getRoomId()).get();

            if (room.isFree()) {
                room.setStatus(RoomStatus.OCCUPIED);
                roomRepository.updateRoomStatus(room.getStatus().getCode(), room.getId());
                Guest guest = guestRepository.findById(stayRequest.getGuestId()).get();
                Stay stay = new Stay(guest, room, stayRequest.getArrival(), stayRequest.getLeaving());
                return stayRepository.save(stay);
            } else {
                throw new RoomOccupiedException("Room is already occupied or JSON parameters are wrong.");
            }
        } catch (NoSuchElementException e) {
            throw new InvalidRoomIdException(e.getMessage());
        }
    }
}
