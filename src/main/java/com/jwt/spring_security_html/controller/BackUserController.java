package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.entity.BackUser;
import com.jwt.spring_security_html.service.BackUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/back")
public class BackUserController {

    private BackUserServiceImpl backUserService;

    private PasswordEncoder passwordEncoder;


    @Autowired
    public void setBackUserService(BackUserServiceImpl backUserService) {
        this.backUserService = backUserService;
    }

    @GetMapping
    public String getHello() {
        return "hello, from back";
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/save")
    public BackUser saveUser(@RequestBody BackUser user) {
        String password = user.getPassword();
        String newPass = passwordEncoder.encode(password);
        String username = user.getUsername();
        Set<String> authorities = Set.of("SUPER_ADMIN");

        BackUser bUser = new BackUser(username, newPass, authorities);
        return backUserService.addBackUser(bUser);
    }

}
