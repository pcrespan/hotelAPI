package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
