package com.jwt.spring_security_html.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    private Integer musicId;
    @Column(name = "music_title")
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;


    public Music(String title) {
        this.title = title;
    }
    public Music(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    @JsonBackReference
    public Album getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                '}';
    }
}

