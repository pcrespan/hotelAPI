package com.api.hotelmanagementsystem.repositories;

import com.api.hotelmanagementsystem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
