package com.example.potatowoong.gamjamugja.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequestDto {
    private String email;
    private String exPassword;
    private String newPassword;
}
