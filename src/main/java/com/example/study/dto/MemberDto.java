package com.example.study.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class MemberDto {

    private int memberSeq;

    //회원 이메일
    @NotNull(message="이메일은 필수 항목입니다.")
    @Email(message = "이메일 형식입니다")
    private String memberEmail;

    //비밀번호
    @NotNull(message = "비밀번호는 필수항목입니다.")
    private String memberPassword;

    //이름
    @NotNull(message = "이름은 필수항목입니다.")
    private String memberName;

    //전화번호
    @NotNull(message = "핸드폰 번호는 필수항목입니다.")
    private String memberPhone;

    //등록아이디
    private String registerId;

    //등록일시
    private String registerDtm;

    //수정아이디
    private String modifyId;

    //수정일시
    private Date modifyDtm;
}
