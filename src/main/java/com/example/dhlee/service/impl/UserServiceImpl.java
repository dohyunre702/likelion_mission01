package com.example.dhlee.service.impl;

import com.example.dhlee.domain.User;
import com.example.dhlee.domain.dto.UserDto;
import com.example.dhlee.domain.dto.UserJoinRequest;
import com.example.dhlee.domain.dto.UserLoginRequest;
import com.example.dhlee.exception.ErrorCode;
import com.example.dhlee.exception.SignException;
import com.example.dhlee.repository.UserRepository;
import com.example.dhlee.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImpl {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Value("%{jwt.token.secret}")
    private String secretKey;
    private final long expiredTimeMs = 1000 * 60 * 60l;

    //회원가입
    public UserDto join(UserJoinRequest userJoinRequest) {

        //같은 이름이 있는 중복회원 => 가입 불가
        userRepository.findByUsername(userJoinRequest.getUser_name())
                .ifPresent(user -> {
                    throw new SignException(ErrorCode.DUPLICATED_USER_NAME, "");
                });

        //중복 체크 통과 뒤 회원가입 = .save() > entity로 값이 저장되어 이동
        User savedUser = userRepository.save(userJoinRequest.toEntity(encoder.encode(userJoinRequest.getPassword())));

        return UserDto.builder()
                .user_id(savedUser.getUser_id())
                .user_name(savedUser.getUser_name())
                .password(savedUser.getPassword())
                .build();
    }

    public UserDto login(UserLoginRequest userLoginRequest) {
        //1. id 찾기 (없다면 2로, 있다면 에러 반환) ㄱ 아래 에러 발생 중
        User selectedUser = userRepository.findByUsername(userLoginRequest.getUser_name())
                .ifPresent(user -> {
                    throw new SignException(ErrorCode.DUPLICATED_USER_NAME, "");
                });
        //2. password 찾기 (일치하면 3으로, 없다면 에러 반환)
        if(!encoder.matches(password, selectedUser.getPassword())) {
            throw new SignException(ErrorCode.INVALID_PASSWORD, "");
        }
        //3. success: dto 빌더 패턴으로 생성해 리턴 (dto에 token 포함)
        String token = JwtTokenUtil.createToken(selectedUser.getUser_name(), secretKey, expiredTimeMs);
        return token;
    }
}
