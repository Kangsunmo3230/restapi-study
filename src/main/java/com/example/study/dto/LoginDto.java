package com.example.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터 없는 기본 생성자를 생성
@Data
public class LoginDto {

    //회원 이메일
    @NotNull(message="이메일은 필수 항목입니다.")
    @Email(message = "이메일 형식입니다")
    private String memberEmail;

    //비밀번호
    @NotNull(message = "비밀번호는 필수 입력 값입니다.")
    private String memberPassword;
}
