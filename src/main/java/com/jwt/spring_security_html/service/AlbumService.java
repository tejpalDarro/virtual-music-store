package com.jwt.spring_security_html.service;

import com.jwt.spring_security_html.dto.AlbumDto;
import com.jwt.spring_security_html.dto.AlbumPageResponse;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
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

    public Album getAlbumById(int id) {
        Optional<Album> op = albumRepository.findById(id);
        if (!op.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return op.get();
    }


//    public AlbumPageResponse getAllAlbumWithPagination(Integer pageNumber, Integer pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//
//        Page<Album> albumPages = albumGenerator.getAlbum();
//    }


}
