package com.example.potatowoong.gamjamugja.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Setter
    private String password;

    @Column(nullable = false)
    @Setter
    private String nickname;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String department;

    @Enumerated(EnumType.STRING) // enum 이름은 DB에 저장
    private Authority authority;

    @Builder
    public Member(Long id,
                  String email,
                  String password,
                  String nickname,
                  Integer age,
                  String sex,
                  String department,
                  Authority authority) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.authority = authority;
    }

}
