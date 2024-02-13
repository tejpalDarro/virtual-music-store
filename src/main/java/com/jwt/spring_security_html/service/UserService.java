package com.jwt.spring_security_html.service;

import com.jwt.spring_security_html.entity.User;
import com.jwt.spring_security_html.entity.product.Album;
import com.jwt.spring_security_html.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User u) {
        return userRepository.save(u);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    public User saveUserWithAlbum(User user, Set<Album> set) {
        user.setAlbums(set);
        return userRepository.save(user);
    }
}
