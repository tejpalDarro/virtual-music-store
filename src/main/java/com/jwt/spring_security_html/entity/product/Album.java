package com.jwt.spring_security_html.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jwt.spring_security_html.entity.User;
import com.jwt.spring_security_html.entity.utility.AlbumPicture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
    @ManyToMany(mappedBy = "albums")
    private Set<User> user;

    @JsonManagedReference
    public List<Music> getMusicList() {
        return musicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album album)) return false;
        return id == album.id && Double.compare(albumPrice, album.albumPrice) == 0 && Objects.equals(albumTitle, album.albumTitle) && Objects.equals(albumArtistName, album.albumArtistName) && Objects.equals(albumReleaseDate, album.albumReleaseDate) && Objects.equals(albumDescription, album.albumDescription) && Objects.equals(musicList, album.musicList) && Objects.equals(coverPicture, album.coverPicture) && Objects.equals(user, album.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumTitle, albumArtistName, albumReleaseDate, albumDescription, musicList, albumPrice, user);
    }

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
