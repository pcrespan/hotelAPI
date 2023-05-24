package com.api.hotelmanagementsystem.entities.projections;

import java.util.Date;

import com.api.hotelmanagementsystem.entities.Room;
import com.api.hotelmanagementsystem.entities.Guest;

public interface StayProjection {
    Room getRoom();
    Guest getGuest();
    Date getArrival();
    Date getLeaving();
}
