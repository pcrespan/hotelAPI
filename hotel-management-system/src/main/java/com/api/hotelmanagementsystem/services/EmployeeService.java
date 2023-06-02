package com.api.hotelmanagementsystem.services;

import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.EmployeeDTO;
import com.api.hotelmanagementsystem.entities.EmployeeMinDTO;
import com.api.hotelmanagementsystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeMinDTO> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(x -> new EmployeeMinDTO(x))
                .collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) {
        return new EmployeeDTO(employeeRepository.findById(id).get());
    }

    public EmployeeDTO insert(Employee employee) {
        return new EmployeeDTO(employeeRepository.save(employee));
    }
}
