package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.domain.Article;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService; 
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService; // BlogService 주입

    @GetMapping("/article_list")
    public String articleList(Model model) {
        // DB에서 게시글 목록을 가져옴
        List<Article> articles = blogService.findAll();
        model.addAttribute("articles", articles); // 모델에 추가
        return "article_list"; // article_list.html 연결
    }

    @PostMapping("/articles") // 게시글 추가를 위한 매핑
    public String addArticle(@ModelAttribute AddArticleRequest request) {
        blogService.save(request); // 게시글 저장
        return "redirect:/article_list"; // 전체 목록으로 리다이렉트
    }

    @GetMapping("/article_edit/{id}") // 게시판 링크 지정
    public String article_edit(Model model, @PathVariable Long id) {
    Optional<Article> list = blogService.findById(id); // 선택한 게시판 글
    if (list.isPresent()) {
        model.addAttribute("article", list.get()); // 존재할 경우 실제 Article 객체를 모델에 추가
    } else {
        // 처리할 로직 추가 (예: 오류 페이지로 리다이렉트, 예외 처리 등)
        return "/error_page/article_error"; // 오류 처리 페이지로 연결(이름 수정됨)
    }
    return "article_edit"; // .HTML 연결
}

    @PostMapping("/api/article_edit/{id}") // 게시글 수정 요청
    public String updateArticle(@PathVariable Long id, @ModelAttribute AddArticleRequest request) {
        blogService.update(id, request); // 게시글 수정
        return "redirect:/article_list"; // 글 수정 이후 목록으로 리다이렉트
    }

    @PostMapping("/api/article_delete/{id}") // 게시글 삭제 요청
    public String deleteArticle(@PathVariable Long id) {
        blogService.delete(id); // 게시글 삭제
        return "redirect:/article_list"; // 삭제 후 목록으로 리다이렉트
    }
}
