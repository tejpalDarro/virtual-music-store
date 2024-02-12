package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.entity.BackUser;
import com.jwt.spring_security_html.service.BackUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("/backUsers")
public class BackUserController {

    private BackUserServiceImpl backUserService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setBackUserService(BackUserServiceImpl backUserService) {
        this.backUserService = backUserService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/backUsers")
    public BackUser saveUser(@RequestBody BackUser user) {
        String password = user.getPassword();
        String newPass = passwordEncoder.encode(password);
        String username = user.getUsername();
        Set<String> authorities = user.getRoles();

        BackUser bUser = new BackUser(username, newPass, authorities);
        return backUserService.addBackUser(bUser);
    }

}
