package com.example.dhlee.domain.dto;

import com.example.dhlee.domain.Post;
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

    public Post toEntity() {
        return Post.builder()
                .id(this.id)
                .title(this.title)
                .body(this.body)
                .created_at(this.created_at)
                .last_modified_at(this.last_modified_at)
                .build();
    }
}
