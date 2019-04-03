package com.ayudantia.demoproyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if(error != null){
            model.addAttribute("error","Contraseña o Password inválida");
        }
        if(logout != null){
            model.addAttribute("message","Te desloggeaste");
        }
        return "login";
    }
}
