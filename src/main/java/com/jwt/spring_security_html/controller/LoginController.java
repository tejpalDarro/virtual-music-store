package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.MusicDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.maper.AlbumMapper;
import com.jwt.spring_security_html.service.AlbumGenerator;
import com.jwt.spring_security_html.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        List<Album> albumList = albumService.getAllAlbum();
        List<AlbumDto> albumDtoList = albumMapper.mapToAlbumDto(albumList);
        model.addAttribute("album", albumDtoList);
        model.addAttribute("music", albumDtoList);

        return "home";
    }

}
