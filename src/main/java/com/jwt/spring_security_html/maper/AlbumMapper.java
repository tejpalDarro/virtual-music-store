package com.jwt.spring_security_html.maper;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.MusicDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.entity.product.Music;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        album.setCoverPicture(albumDto.getPicture());

        return album;
    }

    public List<AlbumDto> mapToAlbumDto(List<Album> albums) {
        List<AlbumDto> albumDtos = new ArrayList<>();
        for (Album a : albums) {
            List<MusicDto> musicDto = new ArrayList<>();
            for (Music m : a.getMusicList()) {
                musicDto.add(new MusicDto(m.getTitle()));
            }
            albumDtos.add(new AlbumDto(a.getAlbumTitle(),a.getAlbumArtistName(), a.getAlbumReleaseDate(), a.getAlbumDescription(), musicDto, a.getAlbumPrice(), a.getCoverPicture()));
        }
        return albumDtos;
    }
}
