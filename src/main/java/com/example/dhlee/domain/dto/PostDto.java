package com.example.dhlee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PostDto {
    private int id;
    private String title;
    private String body;
    private LocalDateTime created_at;
    private LocalDateTime last_modified_at;
}
