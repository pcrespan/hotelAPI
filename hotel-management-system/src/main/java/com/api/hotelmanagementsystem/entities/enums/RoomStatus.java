package com.api.hotelmanagementsystem.entities.enums;

public enum RoomStatus {
    FREE(1),
    OCCUPIED(2);

    private int code;

    private RoomStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RoomStatus valueOf(int code) {
        for (RoomStatus status : RoomStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException();
    }
}
