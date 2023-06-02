package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Employee;
import com.api.hotelmanagementsystem.entities.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Modifying
    @Query(nativeQuery = true, value = """
                    UPDATE tb_employees
                    SET status = :status
                    WHERE id = :id
                    """)
    void updateEmployeeStatus(Long id, Integer status);
}
