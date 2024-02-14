package com.jwt.spring_security_html.service;

import com.jwt.spring_security_html.entity.BackUser;
import com.jwt.spring_security_html.repository.BackUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BackUserServiceImpl implements UserDetailsService {

    @Autowired
    BackUserRepository backUserRepository;

//    public BackUserServiceImpl(BackUserRepository backUserRepository) {
//        super();
//        this.backUserRepository = backUserRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Inside loadByUserName");
//        Optional<BackUser> user = backUserRepository.findByUsername(username);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("user is not present");
//        }
        BackUser backUser = backUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        String uName = backUser.getUsername();
        String password  = backUser.getPassword();
        Set<String> authorities = backUser.getRoles();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        authorities.forEach(role -> {
//            GrantedAuthority auth = new SimpleGrantedAuthority(role);
//            grantedAuthorities.add(auth);
//        });

        grantedAuthorities = authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new User(uName, password, grantedAuthorities);
    }

    public BackUser addBackUser(BackUser user) {
        return backUserRepository.save(user);
    }
}
