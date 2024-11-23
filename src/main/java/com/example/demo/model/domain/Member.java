package com.example.demo.model.domain;

import lombok.*; // 어노테이션 자동 생성
import jakarta.persistence.*; // 기존 javax 후속 버전

@Getter // setter는 없음(무분별한 변경 x)
@Entity // 아래 객체와 DB 테이블을 매핑. JPA가 관리
@Table(name = "Member") // 테이블 이름을 지정. 없는 경우 클래스 이름으로 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 외부 생성자 접근 방지
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "address", nullable = false)
    private String address;

    @Builder // 빌더 패턴 적용
    public Member(String name, String email, String password, int age, String mobile, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.mobile = mobile;
        this.address = address;
    }

    // toString, equals, hashCode 메서드 필요 시 추가
}
