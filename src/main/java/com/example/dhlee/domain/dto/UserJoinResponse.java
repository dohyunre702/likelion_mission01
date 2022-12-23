package com.example.dhlee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

//회원가입 성공 후 저장된 정보 띄우기
@AllArgsConstructor
@Getter
public class UserJoinResponse {
    private int id;
    // private String password;
    private String username;

}
