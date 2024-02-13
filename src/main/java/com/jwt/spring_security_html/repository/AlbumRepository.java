package com.jwt.spring_security_html.repository;

import com.jwt.spring_security_html.entity.product.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Integer> {


}
