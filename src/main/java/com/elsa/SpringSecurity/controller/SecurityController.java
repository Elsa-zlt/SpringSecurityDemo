package com.elsa.SpringSecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {

    @GetMapping(value = {"/home","/"})
    public String home(){
        return "home";
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/admin")
    @Secured("ROLE_ADMIN")
    public String admin(){
        return "admin";
    }
}
