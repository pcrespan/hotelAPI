package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.enums.RoomStatus;
import org.springframework.beans.BeanUtils;

public class RoomDTO {
    private Long id;
    private RoomStatus status;

    public RoomDTO() {
    }

    public RoomDTO(Room room) {
        BeanUtils.copyProperties(room, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
