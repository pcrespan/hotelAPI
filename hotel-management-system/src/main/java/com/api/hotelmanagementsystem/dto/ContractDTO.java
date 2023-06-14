package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.Role;
import com.api.hotelmanagementsystem.entities.Sector;

import java.util.Date;

public class ContractDTO {
    private EmployeeMinDTO employee;
    private Sector sector;
    private Role role;
    private Double salary;
    private Date start;

    public ContractDTO() {
    }

    public ContractDTO(Contract contract) {
        this.employee = new EmployeeMinDTO(contract.getEmployee());
        this.sector = contract.getSector();
        this.role = contract.getRole();
        this.salary = contract.getSalary();
        this.start = contract.getStart();
    }

    public EmployeeMinDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeMinDTO employee) {
        this.employee = employee;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
