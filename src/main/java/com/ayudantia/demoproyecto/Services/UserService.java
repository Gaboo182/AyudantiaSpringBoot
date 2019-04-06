package com.ayudantia.demoproyecto.Services;

import com.ayudantia.demoproyecto.Models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
