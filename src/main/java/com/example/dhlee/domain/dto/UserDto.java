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
    private Long id;
    private String username;
    private String password;
    private String emailAddress;

    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .emailAddress(this.emailAddress)
                .build();
    }
}
