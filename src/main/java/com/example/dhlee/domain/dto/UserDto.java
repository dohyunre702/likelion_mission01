package com.example.dhlee.domain.dto;

import com.example.dhlee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserDto {
    private int user_id;
    private String user_name;
    private String password;

    private LocalDateTime registered_at;
    private LocalDateTime updated_at;
    private LocalDateTime removed_at;

    public User toEntity() {
        return User.builder()
                .user_id(this.user_id)
                .user_name(this.user_name)
                .password(this.password)
                .build();
    }
}
