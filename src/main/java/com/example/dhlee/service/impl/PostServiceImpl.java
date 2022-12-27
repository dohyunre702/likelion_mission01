package com.example.dhlee.service.impl;

import com.example.dhlee.domain.Post;
import com.example.dhlee.domain.dto.PostDto;
import com.example.dhlee.domain.dto.PostRequest;
import com.example.dhlee.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostServiceImpl {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //1. 포스트 등록
    public String newPost(PostRequest postRequest) {
        //1) Dto를 entity로 변환
        Post postEntity = postRequest.toEntity();
        //2) 리포지토리에게 entity를 db에 저장하게 함
        Post saved = postRepository.save(postEntity);
        //3) 저장 후 데이터 dto로 반환
        return null;
    }

    //2. 포스트 상세 조회
    public String getPost(PostDto postDto) {
        //1) id로 데이터 가져오기
        Post postEntity = postRepository.findById(id).orElse(null);
        //2) 가져온 데이터 dto로 반환
        return null;
    }

    //3. 모든 포스트 조회
    public Page<Post> getAllPost() {
        //1) pageRequest 객체 설정 (1페이지당 20개씩)
        PageRequest pageRequest = PageRequest.of(0, 20);
        //2) 리포지토리에서 모두 반환
        return postRepository.findAll(pageRequest);
    }

    //4. 포스트 수정
    public String editPost(PostDto postDto) {
        //1) dto 엔티티로 변환
        Post postEntity = postDto.toEntity();
        //2) id가 db에 있는지 찾기. 아니면 null 반환
        Post targetEntity = postRepository.findById(postEntity.getId()).orElse(null);
        //3) 기존 데이터가 있다면 값 변경
        if(targetEntity != null) {
            postRepository.save(postEntity);
        }
        return null;
    }

    //5. 포스트 삭제
    public String deletePost(PostDto postDto) {
        //1) 삭제대상 찾기
        Post deleteEntity = postRepository.findById(id).orElse(null);
        //2) DB에 대상이 있다면 제거
        if (deleteEntity != null) {
            postRepository.delete(deleteEntity);
        }
        return null;
    }



}
