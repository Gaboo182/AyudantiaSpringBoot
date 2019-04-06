package com.ayudantia.demoproyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String helloWorld(Model model){
        model.addAttribute("hello","HelloWorld");
        return "index";
    }

    @GetMapping(value="/secret")
    public String secret(){
        return "secret";
    }
}
