package com.example.potatowoong.gamjamugja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GamjamugjaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamjamugjaApplication.class, args);
    }

}
