package com.example.dhlee.repository.impl;

import com.example.dhlee.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    UserRepository userRepository;
    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
