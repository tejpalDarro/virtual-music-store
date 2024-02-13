package com.jwt.spring_security_html.dto;

import com.jwt.spring_security_html.entity.product.Album;
import lombok.Data;

@Data
public class AlbumPictureDto {
    private String name;
    private String format;
}
