package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;

public class EmployeeMinDTO {
    private Long id;
    private String name;
    private EmployeeStatus status;

    public EmployeeMinDTO() {
    }

    public EmployeeMinDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.status = employee.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
