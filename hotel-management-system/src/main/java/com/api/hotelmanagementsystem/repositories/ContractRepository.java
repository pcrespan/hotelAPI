package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Contract;
import com.api.hotelmanagementsystem.entities.pk.ContractPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, ContractPK> {
}
