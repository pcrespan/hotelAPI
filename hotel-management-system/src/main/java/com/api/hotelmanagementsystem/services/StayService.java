package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
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

    @Transactional
    public Stay insert(Stay stay) {
        // Error was here. I was testing isFree() on the JSON parameter
        /* It'd probably be better if only the room id was passed as a parameter
            along with arrival and leaving
        */
        Room room = stay.getRoom();

        try {
            Room obj = roomRepository.findById(room.getId()).get();

            if (obj.isFree()) {
                room.setStatus(RoomStatus.OCCUPIED);
                roomRepository.updateRoomStatus(room.getStatus().getCode(), room.getId());
                return stayRepository.save(stay);
            } else {
                throw new RoomOccupiedException("Occupied.");
            }
        } catch (NoSuchElementException e) {
            throw new InvalidRoomIdException(e.getMessage());
        }
    }
}
