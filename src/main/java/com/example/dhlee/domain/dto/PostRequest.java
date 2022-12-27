package com.example.dhlee.domain.dto;

import com.example.dhlee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class PostRequest {
    private String title;
    private String body;

    public User toEntity() {
        return User.builder()
                .user_name(this.title)
                .password(this.body)
                .build();
    }
}
