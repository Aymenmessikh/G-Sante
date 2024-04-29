package com.example.gmt.Repository;

import com.example.gmt.Enitity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long> {
    Roles findRolesByName(String name);
}
