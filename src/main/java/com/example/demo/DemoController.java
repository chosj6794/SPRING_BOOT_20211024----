package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러 어노테이션 명시
public class DemoController{ 
    @GetMapping("/hello") // 전송 방식 GET
    public String hello(Model model) {
    model.addAttribute("data", " 방갑습니다."); // model 설정
    return "hello"; // hello.html 연결
    }
 @GetMapping("/hello2") // 새로운 URL 맵핑
    public String hello2(Model model) {
        // 5개의 속성 추가
        model.addAttribute("name", "홍길동.");
        model.addAttribute("greeting", "방갑습니다.");
        model.addAttribute("when", "오늘.");
        model.addAttribute("weather", "날씨는.");
        model.addAttribute("feel", "매우 좋습니다.");
        return "hello2"; // hello2.html 연결
    }
    @GetMapping("/about_detailed")
    public String about() {
    return "about_detailed";
    }
}