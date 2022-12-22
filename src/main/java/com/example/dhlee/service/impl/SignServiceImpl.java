package com.example.dhlee.service.impl;

import com.example.dhlee.config.security.JwtTokenProvider;
import com.example.dhlee.domain.User;
import com.example.dhlee.domain.dto.UserDto;
import com.example.dhlee.domain.dto.UserJoinRequest;
import com.example.dhlee.error.ErrorCode;
import com.example.dhlee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignServiceImpl {

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;
    private UserDto userDto;

    public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, UserDto userDto) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDto = userDto;
    }

    //회원가입
    public UserDto join(UserJoinRequest userJoinRequest) {

        //같은 이름이 있는 중복회원 => 가입 불가
        userRepository.findByUsername(userJoinRequest.getUsername())
                .ifPresent(username -> {
                    throw new IllegalStateException(String.valueOf(ErrorCode.DUPLICATED_USER_NAME));
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
