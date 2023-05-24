package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Stay;
import com.api.hotelmanagementsystem.entities.pk.StayPK;
import com.api.hotelmanagementsystem.entities.projections.StayProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StayRepository extends JpaRepository<Stay, StayPK> {
    @Query(nativeQuery = true, value = """
                SELECT tb_stay.arrival, tb_stay.leaving, tb_rooms.id, tb_rooms.status, tb_rooms.number
                FROM tb_stay
                INNER JOIN tb_rooms ON tb_stay.room_id = tb_rooms.id
                WHERE tb_stay.guest_id = :guestId
                ORDER BY tb_stay.arrival
                        """)
    List<StayProjection> searchByGuestId(Long guestId);
}
