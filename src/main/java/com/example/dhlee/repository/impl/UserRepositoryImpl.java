package com.example.dhlee.repository.impl;

import com.example.dhlee.domain.User;
import com.example.dhlee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRepositoryImpl {

    //DI
    UserRepository userRepository;

    @Autowired
    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
