package com.jwt.spring_security_html.maper;

import com.jwt.spring_security_html.dto.UserDto;
import com.jwt.spring_security_html.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserMapper {

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setCreated(LocalDate.now());
        return user;
    }
}
