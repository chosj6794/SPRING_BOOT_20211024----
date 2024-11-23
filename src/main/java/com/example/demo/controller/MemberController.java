package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.model.service.AddMemberRequest;
import com.example.demo.model.service.Member_Service;

import jakarta.validation.Valid;

import com.example.demo.model.domain.Member;
import org.springframework.web.bind.annotation.*;



@Controller
public class MemberController {
    private final Member_Service memberService;

    public MemberController(Member_Service memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/join_new") // 회원 가입 페이지 연결
    public String join_new() {
        return "join_new"; // .HTML 연결
    }

    @PostMapping("/api/members") // 회원 가입 저장
    public String addmembers(@Valid @ModelAttribute AddMemberRequest request) {
        memberService.saveMember(request);
        return "join_end"; // .HTML 연결
    }

    @GetMapping("/join_end") // 회원 가입 완료 페이지 연결
    public String join_end() {
        return "join_end"; // .HTML 연결
    }

    @GetMapping("/login") // 로그인 페이지 연결
    public String login() {
        return "login"; // .HTML 연결
    }

    @PostMapping("/api/login_check") // 로그인(아이디, 패스워드) 체크
    public String checkMembers(@ModelAttribute AddMemberRequest request, Model model) {
        try {
            Member member = memberService.loginCheck(request.getEmail(), request.getPassword()); // 패스워드 반환
            model.addAttribute("member", member); // 로그인 성공 시 회원 정보 전달
            return "redirect:/board_list"; // 로그인 성공 후 이동할 페이지
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // 에러 메시지 전달
            return "login"; // 로그인 실패 시 로그인 페이지로 리다이렉트
        }
    }       
    public ResponseEntity<String> registerMember(@Valid @RequestBody AddMemberRequest request) {
        memberService.addMember(request);
        return ResponseEntity.ok("회원가입 성공");
    }
}
