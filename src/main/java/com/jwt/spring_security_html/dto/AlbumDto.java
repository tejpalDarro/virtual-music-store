package com.jwt.spring_security_html.dto;

import com.jwt.spring_security_html.entity.product.Music;
import com.jwt.spring_security_html.entity.utility.AlbumPicture;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto {
    private String title;
    private String artistName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String desc;
    private List<MusicDto> music;
    private double price;
    private AlbumPicture picture;
}
