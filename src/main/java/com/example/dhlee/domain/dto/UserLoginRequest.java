package com.example.dhlee.domain.dto;

import com.example.dhlee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//회원가입 때 입력받을 정보
@AllArgsConstructor
@Getter
@Builder
public class UserLoginRequest {
    private String username;
    private String password;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}
