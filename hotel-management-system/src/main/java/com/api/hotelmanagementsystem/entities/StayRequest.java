package com.api.hotelmanagementsystem.entities;

import java.util.Date;

public class StayRequest {
    private Long guestId;
    private Long roomId;
    private Date arrival;
    private Date leaving;

    public StayRequest() {
    }

    public StayRequest(Long guestId, Long roomId, Date arrival, Date leaving) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.arrival = arrival;
        this.leaving = leaving;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getLeaving() {
        return leaving;
    }

    public void setLeaving(Date leaving) {
        this.leaving = leaving;
    }
}
