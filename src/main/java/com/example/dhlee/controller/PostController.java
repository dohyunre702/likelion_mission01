package com.example.dhlee.controller;

import com.example.dhlee.domain.dto.PostDto;
import com.example.dhlee.domain.dto.PostRequest;
import com.example.dhlee.domain.dto.PostResponse;
import com.example.dhlee.domain.dto.Response;
import com.example.dhlee.service.impl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postService;
    @GetMapping("") //포스트 등록
    public Response<PostResponse> newPost(@RequestBody PostRequest postRequest) {
        PostDto postDto = postService.newPost(postRequest);
        return null;
    }

    @GetMapping("") //포스트 전체조회
    public Response<Page<PostResponse>> getAllPost() {
        return null;
    }

    @GetMapping("/{postId}") //포스트 상세조회
    public Response<PostResponse> getPost(PostRequest postRequest) {
        return null;
    }

    @PutMapping("/{id}") //포스트 수정
    public Response<PostResponse> editPost(PostRequest postRequest) {
        return null;
    }

    @DeleteMapping("/{id}") //포스트 삭제
    public void deletePost(PostRequest postRequest) {
    }

}
