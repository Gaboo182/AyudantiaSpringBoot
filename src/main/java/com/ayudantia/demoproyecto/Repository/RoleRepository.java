package com.ayudantia.demoproyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayudantia.demoproyecto.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
