package com.example.potatowoong.gamjamugja.service;

import com.example.potatowoong.gamjamugja.dto.MemberRequestDto;
import com.example.potatowoong.gamjamugja.dto.MemberResponseDto;
import com.example.potatowoong.gamjamugja.dto.TokenDto;
import com.example.potatowoong.gamjamugja.entity.Member;
import com.example.potatowoong.gamjamugja.jwt.TokenProvider;
import com.example.potatowoong.gamjamugja.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberResponseDto signUp(MemberRequestDto requestDto) {
        if (memberRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Member member = requestDto.toMember(passwordEncoder);
        return MemberResponseDto.of(memberRepository.save(member));
    }

    /*
    1. login 메소드는 MemberRequestDto에 있는 메소드 toAuthentication를 통해 생긴 UsernamePasswordAuthenticationToken 타입의 데이터를 가짐
    2. 주입받은 builder를 통해 AuthenticationManager를 구현한 ProviderManager를 생성한다.
    3. 이후 PrividerManager는 데이터를 AbstractUserDetailsAuthenticationProvider의 자식 클래스인 DaoAuthenticatonProvider를 주입받아서 호출
    4. DaoAuthenticationProvider 내부에 있는 authenticate에서 retrieveUser을 통해 DB에서의 User의 비밀번호가 실제 비밀번호와 맞는지 비교
    5. retrieveUser에서는 DB에서의 User를 꺼내기 위해, CustomUserDetailService에 있는 loadUserByUsername을 가져와 사용
     */
    public TokenDto login(MemberRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }
}
