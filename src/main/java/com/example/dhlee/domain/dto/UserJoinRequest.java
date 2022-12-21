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
    private String username;
    private String password;
    private String emailAddress;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .emailAddress(this.emailAddress)
                .build();
    }
}
