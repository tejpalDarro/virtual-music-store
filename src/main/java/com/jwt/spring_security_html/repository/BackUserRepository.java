package com.jwt.spring_security_html.repository;

import com.jwt.spring_security_html.entity.BackUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackUserRepository extends JpaRepository<BackUser, Integer> {

    public Optional<BackUser> findByUsername(String username);

}
