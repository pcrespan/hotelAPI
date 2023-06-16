package com.api.hotelmanagementsystem.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ContractRequest {
    private Long employeeId;

    @NotNull(message = "Sector id can't be null")
    private Long sectorId;

    @NotNull(message = "Role id can't be null")
    private Long roleId;

    @NotNull(message = "Salary can't be null")
    private Double salary;

    @NotNull(message = "Date can't be null")
    private Date start;

    public ContractRequest() {
    }

    public ContractRequest(Long sectorId, Long roleId, Double salary, Date start) {
        this.sectorId = sectorId;
        this.roleId = roleId;
        this.salary = salary;
        this.start = start;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
