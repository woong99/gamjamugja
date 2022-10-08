package com.example.potatowoong.gamjamugja.repository;

import com.example.potatowoong.gamjamugja.entity.Article;
import com.example.potatowoong.gamjamugja.entity.Authority;
import com.example.potatowoong.gamjamugja.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Article - JPA 연결 테스트")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArticleRepositoryTest {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    ArticleRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired UserRepository userRepository
    ) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @BeforeEach
    public void init() {
        User user = userRepository.save(createUser());
        articleRepository.save(createArticle(user));
    }

    @Order(4)
    @DisplayName("select 테스트")
    @Test
    void givenNoData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(1);
    }

    @Order(3)
    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();
        User user = userRepository.save(createUser());

        Article article = createArticle(user);

        // When
        articleRepository.save(article);
        System.out.println(articleRepository.findAll());

        // Then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @Order(1)
    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // Given
        Article article = articleRepository.findById(2L).orElseThrow();
        article.setPlace("afterTest");

        // When
        articleRepository.save(article);
        Article savedArticle = articleRepository.findById(2L).orElseThrow();

        // Then
        assertThat(savedArticle.getPlace())
                .isNotNull()
                .isEqualTo("afterTest");
    }

    @Order(2)
    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        // Given
        Article article = articleRepository.findById(4L).orElseThrow();
        long previousCount = articleRepository.count();
        System.out.println(articleRepository.findAll());

        // When
        articleRepository.delete(article);

        // Then
        assertThat(articleRepository.count())
                .isEqualTo(previousCount - 1);
    }

    private User createUser() {
        return User.builder()
                .age(24)
                .authority(Authority.ROLE_USER)
                .department("computer")
                .sex("male")
                .email("test@gmail.com")
                .password("1234")
                .nickname("potato")
                .build();

    }

    private Article createArticle(User user) {
        return Article.builder()
                .comment("test")
                .place("test")
                .user(user)
                .meetAt("2022-02-02")
                .build();
    }

}