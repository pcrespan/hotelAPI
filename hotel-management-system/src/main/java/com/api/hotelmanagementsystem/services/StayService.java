package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.repositories.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    public Stay insert(Stay stay) {
        return stayRepository.save(stay);
    }
}
