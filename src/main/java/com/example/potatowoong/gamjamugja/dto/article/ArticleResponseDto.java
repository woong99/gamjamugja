package com.example.potatowoong.gamjamugja.dto.article;

import com.example.potatowoong.gamjamugja.dto.articleComment.ArticleCommentResponseDto;
import com.example.potatowoong.gamjamugja.dto.user.UserResponseDto;
import com.example.potatowoong.gamjamugja.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleResponseDto {
    private Long articleId;
    private String place;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String meetAt;
    private UserResponseDto user;
    private List<ArticleCommentResponseDto> articleComment;

    public static ArticleResponseDto from(Article entity) {
        return new ArticleResponseDto(
                entity.getId(),
                entity.getPlace(),
                entity.getComment(),
                entity.getCreatedAt(),
                entity.getModifiedAt(),
                entity.getMeetAt(),
                UserResponseDto.of(entity.getUser()),
                entity.getArticleComments().stream().map(ArticleCommentResponseDto::from).collect(Collectors.toList())
        );
    }
}
