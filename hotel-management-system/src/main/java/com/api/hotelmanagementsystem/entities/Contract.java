package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.pk.ContractPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_contracts")
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ContractPK id = new ContractPK();

    @NotNull(message = "Salary can't be null")
    private Double salary;

    @NotNull(message = "Date can't be null")
    private Date start;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Contract() {
    }

    public Contract(Employee employee, Sector sector, Double salary, Date start, Role role) {
        id.setEmployee(employee);
        id.setSector(sector);
        this.salary = salary;
        this.start = start;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JsonIgnore
    public Employee getEmployee() {
        return id.getEmployee();
    }

    public Sector getSector() {
        return id.getSector();
    }

    public void setSector(Sector sector) {
        id.setSector(sector);
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