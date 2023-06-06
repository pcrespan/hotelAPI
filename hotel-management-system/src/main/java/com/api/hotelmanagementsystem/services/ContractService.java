package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.*;
import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;
import com.api.hotelmanagementsystem.repositories.ContractRepository;
import com.api.hotelmanagementsystem.repositories.EmployeeRepository;
import com.api.hotelmanagementsystem.repositories.RoleRepository;
import com.api.hotelmanagementsystem.repositories.SectorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Contract insert(ContractRequest contractRequest) {
        // Still need to check if employee exists (create error)
        Employee emp = employeeRepository.findById(contractRequest.getEmployeeId()).get();

        if (emp.active()) {
            throw new IllegalArgumentException("Employee already active");
        }

        Role role = roleRepository.findById(contractRequest.getRoleId()).get();

        if (role == null) {
            throw new IllegalArgumentException("Role does not exist.");
        }

        Sector sector = sectorRepository.findById(contractRequest.getSectorId()).get();

        if (sector == null) {
            throw new IllegalArgumentException("Sector does not exist.");
        }

        emp.setStatus(EmployeeStatus.ACTIVE);
        employeeRepository.updateEmployeeStatus(emp.getId(), emp.getStatus().getCode());
        Contract contract = new Contract(emp, sector, contractRequest.getSalary(), contractRequest.getStart(), role);
        return contractRepository.save(contract);
    }
}
