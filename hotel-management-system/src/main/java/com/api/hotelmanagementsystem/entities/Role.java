package com.api.hotelmanagementsystem.entities;

import com.api.hotelmanagementsystem.entities.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private RoleName roleName;
    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Contract> contracts;

    public Role() {
    }

    public Role(Long id, String name, RoleName roleName) {
        this.id = id;
        this.name = name;
        this.roleName = roleName;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
