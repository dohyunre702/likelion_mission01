package com.example.dhlee.service.impl;

import com.example.dhlee.domain.dto.UserDto;
import com.example.dhlee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        return userRepository.getByUid(username); //userDto
    }
}
