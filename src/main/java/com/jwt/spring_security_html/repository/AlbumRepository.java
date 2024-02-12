package com.jwt.spring_security_html.repository;

import com.jwt.spring_security_html.entity.product.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {


}
