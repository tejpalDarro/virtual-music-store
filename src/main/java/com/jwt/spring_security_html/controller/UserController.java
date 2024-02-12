package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.UserDto;
import com.jwt.spring_security_html.entity.User;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.maper.AlbumMapper;
import com.jwt.spring_security_html.maper.UserMapper;
import com.jwt.spring_security_html.service.AlbumService;
import com.jwt.spring_security_html.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userCont")
public class UserController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/saveuser")
    public String saveUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
//        User user = userMapper.userDtoToUser(userDto);
//        userService.saveUser(user);
        return "save";
    }

}
