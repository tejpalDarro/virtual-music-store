package com.jwt.spring_security_html.service;

import com.jwt.spring_security_html.entity.User;
import com.jwt.spring_security_html.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User u) {
        return userRepository.save(u);
    }

}
