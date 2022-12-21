package com.example.dhlee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

//회원가입 때 입력받을 정보
@AllArgsConstructor
@Getter
public class UserJoinRequest {
    private String userName;
    private String emailAddress;

}
