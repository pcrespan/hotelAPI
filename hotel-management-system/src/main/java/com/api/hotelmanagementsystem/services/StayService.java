package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.projections.StayProjection;
import com.api.hotelmanagementsystem.repositories.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StayService {

    @Autowired
    StayRepository stayRepository;

    public Stay insertStay(Stay stay) {
        return stayRepository.save(stay);
    }

    public List<Stay> findByGuestId(long id) {
        List<StayProjection> list = stayRepository.searchByGuestId(id);
        return list.stream().map(x-> new Stay(x)).collect(Collectors.toList());
    }
}
