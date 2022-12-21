package com.example.dhlee.repository;

import com.example.dhlee.domain.User;
import com.example.dhlee.domain.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long id);
    void findByUsername(String username);
}
