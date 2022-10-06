package com.example.potatowoong.gamjamugja.controller;

import com.example.potatowoong.gamjamugja.adapter.UserAdapter;
import com.example.potatowoong.gamjamugja.dto.ChangePasswordRequestDto;
import com.example.potatowoong.gamjamugja.dto.user.UserRequestDto;
import com.example.potatowoong.gamjamugja.dto.user.UserResponseDto;
import com.example.potatowoong.gamjamugja.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMyUserInfo(@AuthenticationPrincipal UserAdapter userAdapter) {
        return ResponseEntity.ok(UserResponseDto.of(userAdapter.getUser()));
    }

    @PostMapping("/nickname")
    public ResponseEntity<UserResponseDto> setUserNickname(@RequestBody UserRequestDto req) {
        return ResponseEntity.ok(userService.changeUserNickname(req.getEmail(), req.getNickname()));
    }

    @PostMapping("/password")
    public ResponseEntity<UserResponseDto> setUserPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(userService.changeMemberPassword(request.getExPassword(), request.getNewPassword()));
    }

}
