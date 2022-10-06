package com.example.potatowoong.gamjamugja.adapter;

import com.example.potatowoong.gamjamugja.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
@Setter
public class UserAdapter extends org.springframework.security.core.userdetails.User {

    private User user;

    public UserAdapter(User user) {
        super(user.getEmail(), user.getPassword(), List.of(new SimpleGrantedAuthority(user.getAuthority().toString())));
        this.user = user;
    }
}
