package com.example.potatowoong.gamjamugja.dto.articleComment;

import com.example.potatowoong.gamjamugja.entity.Article;
import com.example.potatowoong.gamjamugja.entity.ArticleComment;
import com.example.potatowoong.gamjamugja.entity.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArticleCommentRequestDto {
    private Long articleId;
    private String content;

    public ArticleComment toEntity(User user, Article article) {
        return new ArticleComment(content, article, user);
    }
}
