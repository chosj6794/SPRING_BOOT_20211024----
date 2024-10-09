package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.domain.Article;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService; 
import java.util.List;

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
}
