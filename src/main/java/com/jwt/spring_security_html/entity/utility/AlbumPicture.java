package com.jwt.spring_security_html.entity.utility;

import com.jwt.spring_security_html.entity.product.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album_picture")
public class AlbumPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String format;
    @OneToOne(mappedBy = "coverPicture")
    private Album album;
}
