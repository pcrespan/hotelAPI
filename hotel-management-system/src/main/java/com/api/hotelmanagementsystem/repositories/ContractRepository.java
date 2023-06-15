package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.pk.ContractPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<Contract, ContractPK> {
    @Modifying
    @Query(nativeQuery = true, value = """
                DELETE FROM tb_contracts
                WHERE employee_id = :employee_id
                """)
    void deleteByEmployeeId(@Param("employee_id") Long employee_id);
}
