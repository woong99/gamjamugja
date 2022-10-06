package com.example.potatowoong.gamjamugja.service;

import com.example.potatowoong.gamjamugja.config.SecurityUtil;
import com.example.potatowoong.gamjamugja.dto.user.UserResponseDto;
import com.example.potatowoong.gamjamugja.entity.User;
import com.example.potatowoong.gamjamugja.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto changeUserNickname(String email, String nickname) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        user.setNickname(nickname);
        return UserResponseDto.of(userRepository.save(user));
    }

    @Transactional
    public UserResponseDto changeMemberPassword(String exPassword, String newPassword) {
        User user = userRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        if (!passwordEncoder.matches(exPassword, user.getPassword())) {
            throw new RuntimeException("비밀번호가 맞지 않습니다.");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        return UserResponseDto.of(userRepository.save(user));
    }
}
