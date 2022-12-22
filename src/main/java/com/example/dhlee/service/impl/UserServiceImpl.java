package com.example.dhlee.service.impl;

import com.example.dhlee.config.security.JwtTokenProvider;
import com.example.dhlee.domain.User;
import com.example.dhlee.domain.dto.UserDto;
import com.example.dhlee.domain.dto.UserJoinRequest;
import com.example.dhlee.domain.dto.UserLoginRequest;
import com.example.dhlee.exception.ErrorCode;
import com.example.dhlee.exception.SignException;
import com.example.dhlee.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImpl {

    public UserRepository userRepository;
    public JwtTokenProvider jwtTokenProvider;

    //회원가입
    public UserDto join(UserJoinRequest userJoinRequest) {

        //같은 이름이 있는 중복회원 => 가입 불가
        userRepository.findByUsername(userJoinRequest.getUsername())
                .ifPresent(user -> {
                    throw new SignException(ErrorCode.DUPLICATED_USER_NAME, String.format("username:%s", userJoinRequest.getUsername()));
                });

        //중복 체크 통과 뒤 회원가입 = .save() > entity로 값이 저장되어 이동
        User savedUser = userRepository.save(userJoinRequest.toEntity());

        return UserDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .password(savedUser.getPassword())
                .emailAddress(savedUser.getEmailAddress())
                .build();
    }


    public UserDto login(UserLoginRequest userLoginRequest) {
    }
}
