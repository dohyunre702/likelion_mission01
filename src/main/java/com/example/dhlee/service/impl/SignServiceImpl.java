package com.example.dhlee.service.impl;

import com.example.dhlee.config.security.JwtTokenProvider;
import com.example.dhlee.domain.User;
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
    public UserDto signUp(UserJoinRequest userJoinRequest) {

        //같은 이름이 있는 중복회원 X
        userRepository.findByUsername(userJoinRequest.getUsername())
                .ifPresent(username -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });


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
