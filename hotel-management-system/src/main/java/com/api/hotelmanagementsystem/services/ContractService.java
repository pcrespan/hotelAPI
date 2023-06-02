package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.ContractRequest;
import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.Sector;
import com.api.hotelmanagementsystem.repositories.ContractRepository;
import com.api.hotelmanagementsystem.repositories.EmployeeRepository;
import com.api.hotelmanagementsystem.repositories.SectorRepository;
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

    public Contract insert(ContractRequest contractRequest) {
        // Still need to check if employee exists (create error)
        Employee emp = employeeRepository.findById(contractRequest.getEmployeeId()).get();

        if (emp.active()) {
            throw new IllegalArgumentException("Employee already active");
        }

        Sector sector = sectorRepository.findById(contractRequest.getSectorId()).get();

        if (sector == null) {
            throw new IllegalArgumentException("Sector does not exist.");
        }

        Contract contract = new Contract(emp, sector, contractRequest.getSalary(), contractRequest.getStart());
        return contractRepository.save(contract);
    }
}
