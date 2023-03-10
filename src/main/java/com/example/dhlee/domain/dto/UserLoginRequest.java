package com.example.dhlee.domain.dto;

import com.example.dhlee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//로그인 시 입력받을 정보
@AllArgsConstructor
@Getter
@Builder
public class UserLoginRequest {
    private String user_name;
    private String password;

    public User toEntity() {
        return User.builder()
                .user_name(this.user_name)
                .password(this.password)
                .build();
    }
}
