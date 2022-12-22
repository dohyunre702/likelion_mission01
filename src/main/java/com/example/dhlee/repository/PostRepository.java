package com.example.dhlee.repository;

import com.example.dhlee.domain.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostDto, Long> {
}
