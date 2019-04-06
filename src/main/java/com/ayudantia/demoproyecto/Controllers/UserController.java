package com.ayudantia.demoproyecto.Controllers;

import com.ayudantia.demoproyecto.Models.User;
import com.ayudantia.demoproyecto.Services.UserService;
import com.ayudantia.demoproyecto.Services.SecurityService;
import com.ayudantia.demoproyecto.Validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userForm", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "signup";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/secret";
    }

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
