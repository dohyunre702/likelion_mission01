package com.example.dhlee.domain.dto;

import com.example.dhlee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//회원가입 때 입력받을 정보
@AllArgsConstructor
@Getter
@Builder
public class UserJoinRequest {
    private String user_name;
    private String password;

    public User toEntity(String password) {
        return User.builder()
                .user_name(this.user_name)
                .password(password)
                .build();
    }
}
