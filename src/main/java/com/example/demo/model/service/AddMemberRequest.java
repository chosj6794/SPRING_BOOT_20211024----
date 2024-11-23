package com.example.demo.model.service;

import com.example.demo.model.domain.Member;
import jakarta.validation.constraints.*;

public class AddMemberRequest {

    // 이름: 공백 및 특수문자 허용하지 않음
    @NotBlank(message = "이름은 필수입니다.")
    @Pattern(regexp = "^[^\\s!@#$%^&*()_+]*$", message = "이름에 공백과 특수문자를 포함할 수 없습니다.")
    private String name;

    // 이메일: 공백 허용하지 않고, 이메일 형식 검증
    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    private String email;

    // 비밀번호: 8글자 이상, 대소문자 포함
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "비밀번호는 8글자 이상이며 대문자와 소문자를 포함해야 합니다.")
    private String password;

    // 나이: 19세 이상, 90세 이하
    @Min(value = 19, message = "나이는 19세 이상이어야 합니다.")
    @Max(value = 90, message = "나이는 90세 이하이어야 합니다.")
    private int age; // int 타입으로 설정

    // 모바일: 공백 허용
    @NotBlank(message = "전화번호는 필수입니다.")
    private String mobile;

    // 주소: 공백 허용
    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    // Getter와 Setter 추가
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Member 생성자를 통해 객체 생성
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .age(age) // int 타입으로 Member의 age에 전달
                .mobile(mobile)
                .address(address)
                .build();
    }
}
