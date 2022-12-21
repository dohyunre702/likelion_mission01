package com.example.dhlee.repository.impl;

import com.example.dhlee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRepositoryImpl implements UserRepository {
    UserRepository userRepository;
    
    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails getByUid(String uid) {
        return userRepository.getByUid(uid);
    }
}
