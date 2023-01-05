package com.example.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터 없는 기본 생성자를 생성
@Data
public class LoginDto {

    //회원 이메일
    private String memberEmail;

    //비밀번호
    private String memberPassword;
}
