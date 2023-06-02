package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;
import org.springframework.beans.BeanUtils;

public class EmployeeDTO {
    private Long id;
    private String name;
    private EmployeeStatus status;
    private Contract contract;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        BeanUtils.copyProperties(employee, this);
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
