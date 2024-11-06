package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BlogRepository;
import com.example.demo.model.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 자동 생성
public class BlogService {
    //private final BlogRepository blogRepository; // 리포지토리 선언
    private final BoardRepository blogRepository; // 리포지토리 선언

    //public List<Article> findAll() { // 게시판 전체 목록 조회
    //    return blogRepository.findAll();
    //}
    public List<Board> findAll() { // 게시판 전체 목록 조회
    return blogRepository.findAll();
    }
    
    //public Article save(AddArticleRequest request) {
    //    return blogRepository.save(request.toEntity()); // DTO로부터 Article 엔티티 생성 후 저장
    //}

    //public Optional<Article> findById(Long id) { // 게시판 특정 글 조회
    //    return blogRepository.findById(id);
    //}

    public Optional<Board> findById(Long id) { // 게시판 특정 글 조회
        return blogRepository.findById(id);
        }

    //public void update(Long id, AddArticleRequest request) {
    //    Optional<Article> optionalArticle = blogRepository.findById(id); // 단일 글 조회
    //    optionalArticle.ifPresent(article -> { // 값이 있으면
    //        article.update(request.getTitle(), request.getContent()); // 값을 수정
    //        blogRepository.save(article); // 수정된 Article 객체 저장
    //    });
    // }

    //public void delete(Long id) { // 게시글 삭제
    //    blogRepository.deleteById(id); // ID로 게시글 삭제
    //}
}
