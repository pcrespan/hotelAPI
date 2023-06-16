package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_employees")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotNull(message = "Status can't be null")
    private EmployeeStatus status;

    @NotBlank(message = "SSN can't be null")
    private String socialSecurityNumber;

    @OneToOne(mappedBy = "id.employee", fetch = FetchType.LAZY)
    private Contract contract;

    public Employee() {
    }

    public Employee(Long id, String name, EmployeeStatus status, String socialSecurityNumber) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public boolean active() {
        return status.equals(EmployeeStatus.ACTIVE);
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Contract getContract() {
        return contract;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
