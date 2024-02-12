package com.jwt.spring_security_html.service;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.AlbumPageResponse;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

@Service
public class AlbumService {

    @Autowired
    public AlbumGenerator albumGenerator;

    @Autowired
    public AlbumRepository albumRepository;


    public List<AlbumDto> getAlbum() {
        return albumGenerator.getAlbum();
    }


    public Album addAlbum(Album album) {
        Album al = albumRepository.save(album);
        return al;
    }

    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }


//    public AlbumPageResponse getAllAlbumWithPagination(Integer pageNumber, Integer pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//
//        Page<Album> albumPages = albumGenerator.getAlbum();
//    }


}
