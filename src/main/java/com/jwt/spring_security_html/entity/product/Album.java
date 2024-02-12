package com.jwt.spring_security_html.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jwt.spring_security_html.entity.utility.AlbumPicture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    private int id;
    @Column(name = "album_title")
    private String albumTitle;
    @Column(name = "artist_name")
    private String albumArtistName;
    @Column(name = "album_release_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDate albumReleaseDate;

    @Column(name = "album_desc")
    private String albumDescription;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Music> musicList;
    @Column(name = "album_price")
    private double albumPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cover_picture_id", referencedColumnName = "id")
    private AlbumPicture coverPicture;

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", albumTitle='" + albumTitle + '\'' +
                ", albumArtistName='" + albumArtistName + '\'' +
                ", albumReleaseDate=" + albumReleaseDate +
                ", albumDescription='" + albumDescription + '\'' +
                ", musicList=" + musicList.toString() +
                ", albumPrice=" + albumPrice +
                ", albumPicture=" + coverPicture +
                '}';
    }
}
