package com.ayudantia.demoproyecto.Repository;

import com.ayudantia.demoproyecto.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
