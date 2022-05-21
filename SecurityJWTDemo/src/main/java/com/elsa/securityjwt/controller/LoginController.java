package com.elsa.securityjwt.controller;

import com.elsa.securityjwt.domain.ResponseResult;
import com.elsa.securityjwt.domain.User;
import com.elsa.securityjwt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {

        return loginService.login(user);
    }
}
