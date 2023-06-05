package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Modifying
    @Query(nativeQuery = true, value = """
                    UPDATE tb_rooms
                    SET status = :status
                    WHERE id = :id
                    """)
    void updateRoomStatus(@Param("status") Integer status, @Param("id") Long id);
}
