package com.example.potatowoong.gamjamugja.controller;

import com.example.potatowoong.gamjamugja.dto.MemberRequestDto;
import com.example.potatowoong.gamjamugja.dto.MemberResponseDto;
import com.example.potatowoong.gamjamugja.dto.TokenDto;
import com.example.potatowoong.gamjamugja.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.signUp(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
}
