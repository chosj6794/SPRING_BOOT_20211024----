package com.example.demo.model.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.domain.TestDB;
import com.example.demo.model.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import java.util.List; // List 임포트 추가

@Service // 서비스 계층 명시, 스프링 내부 자동 등록됨
@RequiredArgsConstructor // 생성자 생성
public class TestService {
    private final TestRepository testRepository; // final로 변경

    public List<TestDB> findAllUsers() {
        return testRepository.findAll(); // 모든 사용자 조회
    }
}
