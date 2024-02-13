package com.jwt.spring_security_html.maper;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.AlbumPictureDto;
import com.jwt.spring_security_html.dto.MusicDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.entity.product.Music;
import com.jwt.spring_security_html.entity.utility.AlbumPicture;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AlbumMapper {

    public Album mapToAlbum(AlbumDto albumDto) {
        Album album = new Album();
        Music music = new Music();
        List<Music> musicList = new ArrayList<>();
        if (albumDto.getMusic()!=null) {
            music.setTitle(albumDto.getMusic().get(0).getTitle());
        }

        album.setAlbumTitle(albumDto.getTitle());
        album.setAlbumArtistName(albumDto.getArtistName());
        album.setAlbumDescription(albumDto.getDesc());
        album.setAlbumReleaseDate(albumDto.getDate());
        album.setAlbumPrice(albumDto.getPrice());
        music.setAlbum(album);
        if (albumDto.getMusic()!=null) {
            for (MusicDto m : albumDto.getMusic()) {
                musicList.add(new Music(m.getTitle(), album));
            }
        }
        album.setMusicList(musicList);
        AlbumPicture albumPicture = new AlbumPicture();
        albumPicture.setName(albumDto.getPicture().getName());
        albumPicture.setFormat(albumDto.getPicture().getFormat());
        album.setCoverPicture(albumPicture);

        return album;
    }

    public List<AlbumDto> mapToAlbumDto(List<Album> albums) {
        List<AlbumDto> albumDtos = new ArrayList<>();
        for (Album a : albums) {
            List<MusicDto> musicDto = new ArrayList<>();
            for (Music m : a.getMusicList()) {
                musicDto.add(new MusicDto(m.getTitle()));
            }
            AlbumPictureDto albumPictureDto = new AlbumPictureDto();
            albumPictureDto.setName(a.getCoverPicture().getName());
            albumPictureDto.setFormat(a.getCoverPicture().getFormat());
            albumDtos.add(new AlbumDto(a.getAlbumTitle(),a.getAlbumArtistName(), a.getAlbumReleaseDate(), a.getAlbumDescription(), musicDto, a.getAlbumPrice(), albumPictureDto));
        }
        return albumDtos;
    }

    public Set<AlbumDto> mapToSetAlbumDto(Set<Album> albums) {
        Set<AlbumDto> albumDtos = new HashSet<>();
        for (Album a : albums) {
            List<MusicDto> musicDto = new ArrayList<>();
            for (Music m : a.getMusicList()) {
                musicDto.add(new MusicDto(m.getTitle()));
            }
            AlbumPictureDto albumPictureDto = new AlbumPictureDto();
            albumPictureDto.setName(a.getCoverPicture().getName());
            albumPictureDto.setFormat(a.getCoverPicture().getFormat());
            albumDtos.add(new AlbumDto(a.getAlbumTitle(),a.getAlbumArtistName(), a.getAlbumReleaseDate(), a.getAlbumDescription(), musicDto, a.getAlbumPrice(), albumPictureDto));
        }
        return albumDtos;
    }

    public AlbumDto mapAlbumToAlbumDto(Album album) {
        AlbumDto albumDto = new AlbumDto();
        albumDto.setArtistName(album.getAlbumArtistName());
        albumDto.setDesc(album.getAlbumDescription());
        albumDto.setDate(album.getAlbumReleaseDate());
        albumDto.setPrice(album.getAlbumPrice());
        albumDto.setTitle(album.getAlbumTitle());
        List<MusicDto> musicDto = new ArrayList<>();
        for (Music m : album.getMusicList()) {
            MusicDto musicDto1 = new MusicDto();
            musicDto1.setTitle(m.getTitle());
            musicDto.add(musicDto1);
        }
        albumDto.setMusic(musicDto);
        AlbumPictureDto albumPictureDto = new AlbumPictureDto();
        albumPictureDto.setName(album.getCoverPicture().getName());
        albumPictureDto.setFormat(album.getCoverPicture().getFormat());
        albumDto.setPicture(albumPictureDto);
        return albumDto;
    }
}
