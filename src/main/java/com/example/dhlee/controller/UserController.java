package com.example.dhlee.controller;

import com.example.dhlee.domain.dto.*;
import com.example.dhlee.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest) {
        UserDto userDto = userService.join(userJoinRequest);
        return Response.success(new UserJoinResponse(userDto.getUser_id(), userDto.getUser_name()));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        UserDto userDto = userService.login(userLoginRequest);
        return Response.success(new UserLoginResponse());
    }

}
