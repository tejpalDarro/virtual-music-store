package com.jwt.spring_security_html.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactAlbumDto {
    private String title;
    private String artistName;
    private LocalDate date;
    private String desc;
    private double price;
    private List<MusicDto> music;
    private AlbumPictureDto picture;
}
