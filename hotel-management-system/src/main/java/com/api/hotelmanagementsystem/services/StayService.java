package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Guest;
import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.repositories.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    public Stay insert(Guest guest, Room room, Date arrival, Date leaving) {
        Stay stay = new Stay(guest, room, arrival, leaving);
        stayRepository.save(stay);
        return stay;
    }
}
