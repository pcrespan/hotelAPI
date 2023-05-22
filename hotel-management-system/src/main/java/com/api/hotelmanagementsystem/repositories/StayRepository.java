package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.pk.StayPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay, StayPK> {
}
