package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.domain.Article;
import com.example.demo.model.service.BlogService; // BlogService 임포트
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
}