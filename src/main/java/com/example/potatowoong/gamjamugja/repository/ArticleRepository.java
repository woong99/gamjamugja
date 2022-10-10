package com.example.potatowoong.gamjamugja.repository;

import com.example.potatowoong.gamjamugja.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
