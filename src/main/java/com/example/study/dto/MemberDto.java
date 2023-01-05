package com.example.study.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private int memberSeq;

    //회원 이메일
    private String memberEmail;

    //비밀번호
    private String memberPassword;

    //이름
    private String memberName;

    //전화번호
    private String memberPhone;

    //등록아이디
    private String registerId;

    //등록일시
    private Date registerDtm;

    //수정아이디
    private String modifyId;

    //수정일시
    private Date modifyDtm;

}
