package com.api.hotelmanagementsystem.entities.enums;

public enum EmployeeStatus {
    INACTIVE(0),
    ACTIVE(1);

    private int code;

    private EmployeeStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static EmployeeStatus valueOf(int code) {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code.");
    }
}
