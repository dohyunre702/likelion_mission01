package com.example.dhlee.service.impl;

import com.example.dhlee.config.security.JwtTokenProvider;
import com.example.dhlee.domain.User;
import com.example.dhlee.domain.dto.SignUpResultDto;
import com.example.dhlee.domain.dto.UserDto;
import com.example.dhlee.domain.dto.UserJoinRequest;
import com.example.dhlee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SignServiceImpl {
    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;

    private UserDto userDto;

    @Autowired
    public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //회원가입
    @Override
    public UserDto signUp(UserJoinRequest userJoinRequest) {

        //uid 중복 체크
        userRepository.findByUsername(userJoinRequest.getUsername())



        //중복 체크 통과 뒤 회원가입 = .save()
        User savedUser = userRepository.save(userJoinRequest.toEntity());

        return UserDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .password(savedUser.getPassword())
                .emailAddress(savedUser.getEmailAddress())
                .build();
    }

}
