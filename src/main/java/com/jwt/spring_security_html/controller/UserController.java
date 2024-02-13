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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user-cont")
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

    @GetMapping("/getUser")
    public List<UserDto> getUser() {
        return userMapper.listOfUserToUserDto(userService.getAllUser());
    }

    @GetMapping("/getbyid/{id}")
    public UserDto getUserById(@PathVariable(name = "id") int id) {
        User user = userService.getUserById(id);
        return userMapper.UserToUserDto(user);
    }

    @PostMapping("/get/{id}")
    public UserDto updateAlbumToUser(@PathVariable(name = "id") int id) {

        Album album = albumService.getAlbumById(id);
        Album album1 = albumService.getAlbumById(id+1);
        AlbumDto albumDto = albumMapper.mapAlbumToAlbumDto(album);
        User user = userService.getUserById(id);
        Set<Album> set = new HashSet<>();
        set.add(album);
        set.add(album1);
        User res = userService.saveUserWithAlbum(user, set);
        return userMapper.UserToUserDto(res);
    }
    @PostMapping("/saveuser")
    public String saveUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        User user = userMapper.userDtoToUser(userDto);
        User u = userService.saveUser(user);
        System.out.println(u);

        return "success";
    }

}
