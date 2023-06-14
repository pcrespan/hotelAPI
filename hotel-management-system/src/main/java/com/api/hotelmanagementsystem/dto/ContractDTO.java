package com.api.hotelmanagementsystem.dto;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.Role;
import com.api.hotelmanagementsystem.entities.Sector;
import com.api.hotelmanagementsystem.entities.pk.ContractPK;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ContractDTO {
    private ContractPK id = new ContractPK();
    private Role role;
    private Double salary;
    private Date start;

    public ContractDTO() {
    }

    public ContractDTO(Contract contract) {
        BeanUtils.copyProperties(contract, this);
    }

    public void setEmployee(Employee employee) {
        id.setEmployee(employee);
    }

    public void setSector(Sector sector) {
        id.setSector(sector);
    }

    public Employee getEmployee() {
        return id.getEmployee();
    }

    public Sector getSector() {
        return id.getSector();
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
