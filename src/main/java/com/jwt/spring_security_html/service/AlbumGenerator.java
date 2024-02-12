package com.jwt.spring_security_html.service;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.MusicDto;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.entity.product.Music;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AlbumGenerator {

    private static List<AlbumDto> album;
    private static AlbumDto album1;
    private static AlbumDto album2;

    static {
//        musicList = new ArrayList<>();
//        album = new Album();
//
//        album.setAlbumTitle("The Midnight Sun");
//        album.setAlbumDescription("Desc");
//        album.setAlbumPrice(9.99);
//        album.setAlbumReleaseDate(LocalDate.of(2023,7,29));
//
//
//        music1 = new Music();
//        music1.setTitle("Sunset Boulevard");
//        music1.setAlbum(album);
//
//        musicList.add(music1);
//
//        album.setMusicList(musicList);


//        list = Arrays.asList(
//                new Album(1, "h", LocalDate.of(2023,7,1), "this", List.of(new Music("helli")), 9);
//                new Album(1,
//                        "The Midnight Sun",
//                        LocalDate.of(2023,7, 1),
//                        "This album is a fusion of jazz and electronic music, with a focus on creating a relaxing atmosphere.",
//                        List.of(new Music("hello")),
//                        9.99),
//                new Album(2, "The Last Goodbye", LocalDate.of(2023, 12, 15), "This album is a collection of emotional ballads that explore the themes of love and loss.", List.of(new Music(201, "welcome")), 12.99),
//                new Album(2, "Electric Dreams", LocalDate.of(2024, 3, 1), "This album is a high-energy mix of electronic dance music and pop, designed to get you moving", List.of(new Music(301, "welcome")), 14.99)

//        );
    }

    public List<AlbumDto> getAlbum() {
        album = new ArrayList<>();

        album1 = new AlbumDto();

        album1.setTitle("The Midnight Sun");
        album1.setDesc("Desc");
        album1.setPrice(9.99);
        album1.setDate(LocalDate.of(2023,7,29));


        album1.setMusic(List.of(new MusicDto("Sunset Boulevard"),
                new MusicDto("Midnight Drive"),
                new MusicDto("Neon Lights"),
                new MusicDto("City of Angels")));

        album2 = new AlbumDto();

        album2.setTitle("The Last Goodbye");
        album2.setDesc("Desc");
        album2.setPrice(9.99);
        album2.setDate(LocalDate.of(2019,3,1));


        album2.setMusic(List.of(new MusicDto("Fading Memories"),
                new MusicDto("Broken Dreams"),
                new MusicDto("Lost in Time"),
                new MusicDto("The Last Goodbye")));

        album.add(album1);
        album.add(album2);

//        list = Arrays.asList(
//                new Album(1, "h", LocalDate.of(2023,7,1), "this", List.of(new Music("helli")), 9);
//                new Album(1,
//                        "The Midnight Sun",
//                        LocalDate.of(2023,7, 1),
//                        "This album is a fusion of jazz and electronic music, with a focus on creating a relaxing atmosphere.",
//                        List.of(new Music("hello")),
//                        9.99),
//                new Album(2, "The Last Goodbye", LocalDate.of(2023, 12, 15), "This album is a collection of emotional ballads that explore the themes of love and loss.", List.of(new Music(201, "welcome")), 12.99),
//                new Album(2, "Electric Dreams", LocalDate.of(2024, 3, 1), "This album is a high-energy mix of electronic dance music and pop, designed to get you moving", List.of(new Music(301, "welcome")), 14.99)

//        );
        return album;

    }
}

