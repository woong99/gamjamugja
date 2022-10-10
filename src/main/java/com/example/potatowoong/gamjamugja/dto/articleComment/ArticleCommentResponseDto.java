package com.example.potatowoong.gamjamugja.dto.articleComment;

import com.example.potatowoong.gamjamugja.dto.user.UserResponseDto;
import com.example.potatowoong.gamjamugja.entity.ArticleComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentResponseDto {
    private Long articleCommentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long articleId;
    private UserResponseDto user;

    public static ArticleCommentResponseDto from(ArticleComment entity) {
        return new ArticleCommentResponseDto(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getModifiedAt(),
                entity.getArticle().getId(),
                UserResponseDto.of(entity.getUser())
        );
    }
}
