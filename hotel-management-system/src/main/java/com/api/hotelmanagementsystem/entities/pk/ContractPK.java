package com.api.hotelmanagementsystem.entities.pk;

import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.Sector;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public ContractPK() {
    }

    public ContractPK(Employee employee, Sector sector) {
        this.employee = employee;
        this.sector = sector;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractPK that = (ContractPK) o;
        return Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee);
    }
}
