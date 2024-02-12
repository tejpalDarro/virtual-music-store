package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.MusicDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.maper.AlbumMapper;
import com.jwt.spring_security_html.service.AlbumService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AlbumMapper albumMapper;

    private final AlbumService albumService;

    public AdminController(AlbumMapper albumMapper, AlbumService albumService) {
        this.albumMapper = albumMapper;
        this.albumService = albumService;
    }

    @GetMapping("/home")
    public String getHome(AlbumDto albumDto) {
        return "admin_home";
    }

    @PostMapping("/saveAlbum")
    public String saveAlbum(AlbumDto albumDto, Errors errors, Model model) {
        if (null!=errors && errors.getErrorCount()>0) {
            errors.getAllErrors().forEach(a -> System.out.println(a.getDefaultMessage()));
        } else {
            System.out.println("success: " + albumDto);
            Album album = albumMapper.mapToAlbum(albumDto);
            System.out.println(album);
            albumService.addAlbum(album);
        }
        return "admin_home";
    }

    @PostMapping(value = "/saveAlbum", params = {"addMusic"})
    public String addMusic(AlbumDto albumDto, BindingResult bindingResult) {
        if (null!=albumDto) {
            if (null==albumDto.getMusic()) {
                List<MusicDto> musicDos = new ArrayList<>();
                musicDos.add(new MusicDto());
                albumDto.setMusic(musicDos);
            } else {
                albumDto.getMusic().add(new MusicDto());
            }
        }
        return "admin_home";
    }

    @PostMapping(value = "/saveAlbum", params = {"removeMusic"})
    public String removeMusic(AlbumDto albumDto, BindingResult bindingResult, HttpServletRequest request) {
        albumDto.getMusic().remove(Integer.parseInt(request.getParameter("removeMusic")));
        return "admin_home";
    }
}
