package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Contract;

import java.util.Date;

public class ContractMinDTO {
    private Double salary;
    private Date start;
    private EmployeeMinDTO employee;

    public ContractMinDTO() {
    }

    public ContractMinDTO(Contract contract) {
        this.salary = contract.getSalary();
        this.start = contract.getStart();
        this.employee = new EmployeeMinDTO(contract.getEmployee());
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

    public EmployeeMinDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeMinDTO employee) {
        this.employee = employee;
    }
}
