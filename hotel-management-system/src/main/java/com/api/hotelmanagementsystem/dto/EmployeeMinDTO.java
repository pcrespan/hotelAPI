package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;

public class EmployeeMinDTO {
    private Long id;
    private String name;
    private EmployeeStatus status;

    private String socialSecurityNumber;

    public EmployeeMinDTO() {
    }

    public EmployeeMinDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.status = employee.getStatus();
        this.socialSecurityNumber = employee.getSocialSecurityNumber();
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
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
