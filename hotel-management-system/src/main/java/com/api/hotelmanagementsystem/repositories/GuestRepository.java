package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
