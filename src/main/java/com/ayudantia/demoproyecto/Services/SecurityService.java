package com.ayudantia.demoproyecto.Services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
