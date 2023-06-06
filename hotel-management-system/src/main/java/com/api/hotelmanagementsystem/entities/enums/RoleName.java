package com.api.hotelmanagementsystem.entities.enums;

public enum RoleName {
    TEMP(0),
    RECEPTIONIST(1),
    ACCOUNTANT(2),
    SALESMAN(3),
    REGIONAL_MANAGER(4),
    HUMAN_RESOURCES(5);

    private int code;

    private RoleName(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RoleName valueOf(int code) {
        for (RoleName roleName : RoleName.values()) {
            if (roleName.getCode() == code) {
                return roleName;
            }
        }
        throw new IllegalArgumentException("Invalid code.");
    }
}
