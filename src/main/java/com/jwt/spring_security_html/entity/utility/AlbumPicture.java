package com.jwt.spring_security_html.entity.utility;

import com.jwt.spring_security_html.entity.product.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlbumPicture that)) return false;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(format, that.format) && Objects.equals(album, that.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, format, album);
    }

    @Override
    public String toString() {
        return "AlbumPicture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
//                ", album=" + album +
                '}';
    }
}
