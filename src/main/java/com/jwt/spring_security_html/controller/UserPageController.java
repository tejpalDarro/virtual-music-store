package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.maper.AlbumMapper;
import com.jwt.spring_security_html.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumMapper albumMapper;

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello world";
//    }

    @GetMapping("/collection")
    public String getCollection(Model model) {
        List<Album> albumList = albumService.getAllAlbum();
        List<AlbumDto> albumDtoList = albumMapper.mapToAlbumDto(albumList);
        model.addAttribute("album", albumDtoList);
        model.addAttribute("music", albumDtoList);
        return "collections";
    }

    @GetMapping("/joinus")
    public String joinUs() {
        return "joinus";
    }

}
