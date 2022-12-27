package com.example.dhlee.repository;

import com.example.dhlee.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Integer> {

    @Override
    Page<Post> findAll(Pageable pageable); //조회(페이징)

    @Override
    Optional<Post> findById(Integer Integer);//id로 찾기

    @Override
    void deleteById(Integer Integer); //삭제하기

}
