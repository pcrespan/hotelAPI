package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.pk.ContractPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_contracts")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ContractPK id = new ContractPK();
    private Double salary;
    private Date start;

    public Contract() {
    }

    public Contract(Employee employee, Sector sector, Double salary, Date start) {
        id.setEmployee(employee);
        id.setSector(sector);
        this.salary = salary;
        this.start = start;
    }

    @JsonIgnore
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