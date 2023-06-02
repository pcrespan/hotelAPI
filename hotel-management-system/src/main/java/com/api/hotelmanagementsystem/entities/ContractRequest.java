package com.api.hotelmanagementsystem.entities;

import java.util.Date;

public class ContractRequest {
    private Long employeeId;
    private Long sectorId;
    private Double salary;
    private Date start;

    public ContractRequest() {
    }

    public ContractRequest(Long sectorId, Double salary, Date start) {
        this.sectorId = sectorId;
        this.salary = salary;
        this.start = start;
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
