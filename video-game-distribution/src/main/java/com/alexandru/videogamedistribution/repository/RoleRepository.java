package com.alexandru.videogamedistribution.repository;

import com.alexandru.videogamedistribution.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
