package com.api.hotelmanagementsystem.controllers;

import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.dto.EmployeeDTO;
import com.api.hotelmanagementsystem.dto.EmployeeMinDTO;
import com.api.hotelmanagementsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeMinDTO>> findAll() {
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody Employee employee) {
        EmployeeDTO emp = employeeService.insert(employee);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId())
                .toUri();

        return ResponseEntity.created(uri).body(emp);
    }
}
