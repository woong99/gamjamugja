package com.example.potatowoong.gamjamugja.controller;

import com.example.potatowoong.gamjamugja.dto.ChangePasswordRequestDto;
import com.example.potatowoong.gamjamugja.dto.MemberRequestDto;
import com.example.potatowoong.gamjamugja.dto.MemberResponseDto;
import com.example.potatowoong.gamjamugja.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        MemberResponseDto myInfoBySecurity = memberService.getMyInfoBySecurity();
        log.info(myInfoBySecurity.getNickname());
        return ResponseEntity.ok(myInfoBySecurity);
    }

    @PostMapping("/nickname")
    public ResponseEntity<MemberResponseDto> setMemberNickname(@RequestBody MemberRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberNickname(request.getEmail(), request.getNickname()));
    }

    @PostMapping("/password")
    public ResponseEntity<MemberResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberPassword(request.getExPassword(), request.getNewPassword()));
    }

}
