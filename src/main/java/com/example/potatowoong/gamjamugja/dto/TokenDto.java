package com.example.potatowoong.gamjamugja.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Token의 값을 헤더에서 뽑거나 헤더에서 삽입할 때 쓰는 DTO
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long tokenExpiresIn;
}
