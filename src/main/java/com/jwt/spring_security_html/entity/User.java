package com.jwt.spring_security_html.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jwt.spring_security_html.entity.product.Album;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_pass")
    private  String password;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_money", columnDefinition = "integer default 30")
    private double money = 30;
    @Column(name = "user_created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate created;
    @ManyToMany
    @JoinTable(
            name = "user_album",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> albums;
}
