package com.example.potatowoong.gamjamugja.controller;

import com.example.potatowoong.gamjamugja.annotation.AuthUser;
import com.example.potatowoong.gamjamugja.dto.articleComment.ArticleCommentRequestDto;
import com.example.potatowoong.gamjamugja.dto.articleComment.ArticleCommentResponseDto;
import com.example.potatowoong.gamjamugja.entity.User;
import com.example.potatowoong.gamjamugja.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public ResponseEntity<ArticleCommentResponseDto> postNewArticleComment(@AuthUser User user, @RequestBody ArticleCommentRequestDto dto) {
        return ResponseEntity.ok(articleCommentService.saveArticleComment(user, dto));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteArticleComment(@AuthUser User user, @RequestParam Long id) {
        articleCommentService.deleteArticleComment(user, id);
        return ResponseEntity.ok().build();
    }
}
