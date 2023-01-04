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
   // @JsonProperty(value="member_seq")
    private int member_seq;

    //회원 이메일
  //  @JsonProperty(value="member_email")
    private String member_email;

    //비밀번호
   // @JsonProperty(value="member_password")
    private String member_password;

    //이름
   // @JsonProperty(value="member_name")
    private String member_name;

    //전화번호
   // @JsonProperty(value="member_phone")
    private String member_phone;

    //등록아이디
  //  @JsonProperty(value="register_id")
    private String register_id;

    //등록일시
 //   @JsonProperty(value="register_dtm")
    private Date register_dtm;

    //수정아이디
   // @JsonProperty(value="modify_id")
    private String modify_id;

    //수정일시
  //  @JsonProperty(value="modify_dtm")
    private Date modify_dtm;

}
