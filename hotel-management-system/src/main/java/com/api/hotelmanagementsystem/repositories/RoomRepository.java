package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
