package com.jwt.spring_security_html.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getHello() {
        return "Hello from test";
    }

    @PostMapping
    public Authentication getAuth(Authentication auth) {
        return auth;
    }
}
