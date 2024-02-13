package com.jwt.spring_security_html.controller;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.TestDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.maper.AlbumMapper;
import com.jwt.spring_security_html.service.AlbumService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    public final AlbumService albumService;

    public final AlbumMapper albumMapper;

    public AlbumController(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumService = albumService;
        this.albumMapper = albumMapper;
    }

    @GetMapping("/all")
    public List<AlbumDto> getAll() {
        return albumService.getAlbum();
    }

    @GetMapping("get-album")
    public List<AlbumDto> getAlbum() {
        List<Album> album = albumService.getAllAlbum();
        return albumMapper.mapToAlbumDto(album);
    }

    @GetMapping("/get/{id}")
    public AlbumDto getById(@PathVariable(name = "id") int id) {
        System.out.println(id);
        Album album = albumService.getAlbumById(id);
        AlbumDto albumDto = albumMapper.mapAlbumToAlbumDto(album);
        return albumDto;
    }

    @PostMapping("/test")
    public String setAlbum(@RequestBody TestDto albumDto) {

        System.out.println(albumDto.getTitle());
        System.out.println(albumDto.getDescName());
        System.out.println(albumDto.getDate());
        return "added";
    }

    @PostMapping("/add")
    public String setAlbum(@RequestBody AlbumDto albumDto) {

        Album album = albumMapper.mapToAlbum(albumDto);

        System.out.println(album);
        albumService.addAlbum(album);
        return "added";
    }

    @PostMapping("/addAlbumToDB")
    public String add2(Model model) {
        if (model.getAttribute("album") == null) {
            System.out.println("NULL album");
        } else {
            System.out.println("Object get");
        }
       return "forward:/admin/home";
    }



}
