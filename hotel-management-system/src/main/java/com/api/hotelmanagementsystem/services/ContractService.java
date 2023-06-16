package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.dto.ContractDTO;
import com.api.hotelmanagementsystem.entities.*;
import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;
import com.api.hotelmanagementsystem.repositories.ContractRepository;
import com.api.hotelmanagementsystem.repositories.EmployeeRepository;
import com.api.hotelmanagementsystem.repositories.RoleRepository;
import com.api.hotelmanagementsystem.repositories.SectorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
        Employee emp = employeeRepository.findById(contractRequest.getEmployeeId()).get();
        Role role = roleRepository.findById(contractRequest.getRoleId()).get();
        Sector sector = sectorRepository.findById(contractRequest.getSectorId()).get();

        if (emp.active()) {
            throw new IllegalArgumentException("Employee already has a contract");
        }

        emp.setStatus(EmployeeStatus.ACTIVE);
        employeeRepository.updateEmployeeStatus(emp.getId(), emp.getStatus().getCode());
        Contract contract = new Contract(emp, sector, contractRequest.getSalary(), contractRequest.getStart(), role);
        return contractRepository.save(contract);
    }

    @Transactional
    public ContractDTO updateContract(ContractRequest contractRequest) {
        contractRepository.deleteByEmployeeId(contractRequest.getEmployeeId());
        Contract c = new Contract(employeeRepository.findById(contractRequest.getEmployeeId()).get(),
                sectorRepository.findById(contractRequest.getSectorId()).get(),
                contractRequest.getSalary(),
                contractRequest.getStart(),
                roleRepository.findById(contractRequest.getRoleId()).get());
        return new ContractDTO(contractRepository.save(c));
    }
}
