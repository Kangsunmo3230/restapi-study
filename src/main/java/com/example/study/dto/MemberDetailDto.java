package com.example.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDto {

    @NotNull(message="이메일은 필수 항목입니다.")
    @Email(message = "이메일 형식입니다")
    private String memberEmail;

    @NotNull(message="이름은 필수 항목입니다.")
    private String memberName;

    @NotNull(message="핸드폰는 필수 항목입니다.")
    private String memberPhone;

}
