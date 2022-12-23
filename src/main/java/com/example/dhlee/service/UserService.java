package com.example.dhlee.service;

import com.example.dhlee.domain.dto.*;

public interface UserService {
    UserDto join (UserJoinRequest userJoinRequest); //회원가입
    UserLoginResponse login (UserLoginRequest userLoginRequest); //로그인

}
