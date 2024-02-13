package com.jwt.spring_security_html.react.controller;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.AlbumPictureDto;
import com.jwt.spring_security_html.dto.MusicDto;
import com.jwt.spring_security_html.dto.ReactAlbumDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.entity.product.Music;
import com.jwt.spring_security_html.entity.utility.AlbumPicture;
import com.jwt.spring_security_html.maper.AlbumMapper;
import com.jwt.spring_security_html.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class ReactUserController {

    private AlbumService albumService;
    private AlbumMapper albumMapper;

    public ReactUserController(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumService = albumService;
        this.albumMapper = albumMapper;
    }

    @GetMapping("/getlist")
    public List<ReactAlbumDto> getList() {
        List<Album> albumList = albumService.getAllAlbum();
//        List<AlbumDto> albumDtoList = albumMapper.mapToAlbumDto(albumList);
//        for (AlbumDto a : albumDtoList) {
//            System.out.println(a);
//        }
        List<ReactAlbumDto> reactAlbumDtos = new ArrayList<>();
        for (Album a : albumList) {
            ReactAlbumDto rt = new ReactAlbumDto();
            rt.setArtistName(a.getAlbumArtistName());
            rt.setTitle(a.getAlbumTitle());
            rt.setDesc(a.getAlbumDescription());
            rt.setDate(a.getAlbumReleaseDate());
            rt.setPrice(a.getAlbumPrice());
            rt.setMusic(convertMusicToMusicDto(a.getMusicList()));
            rt.setPicture(convertPictureToPictureDto(a.getCoverPicture()));
            reactAlbumDtos.add(rt);
        }
        return reactAlbumDtos;
    }

    @GetMapping("/get")
    public List<AlbumDto> getListDto() {
        return albumMapper.mapToAlbumDto(albumService.getAllAlbum());
    }

    private AlbumPictureDto convertPictureToPictureDto(AlbumPicture coverPicture) {
       AlbumPictureDto ap = new AlbumPictureDto();
       ap.setName(coverPicture.getName());
       ap.setFormat(coverPicture.getFormat());
       return ap;
    }

    private List<MusicDto> convertMusicToMusicDto(List<Music> musicList) {
        List<MusicDto> musicDtos = new ArrayList<>();
        for (Music m : musicList) {
            MusicDto md = new MusicDto();
            md.setTitle(m.getTitle());
            musicDtos.add(md);
        }
        return musicDtos;
    }
}
