package com.example.potatowoong.gamjamugja.repository;

import com.example.potatowoong.gamjamugja.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
