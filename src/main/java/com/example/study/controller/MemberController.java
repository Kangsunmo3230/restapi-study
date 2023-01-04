package com.example.study.controller;


import com.example.study.dao.MemberDao;
import com.example.study.dto.MemberDto;
import com.example.study.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j

//JSON/XML형태로 객체 데이터 반환을 목적
@RestController

public class MemberController {

    @Autowired
    MemberService memberService;



    /*이메일과 비밀번호로 회원 검색*/
    @GetMapping(value = "/api/member/register")
    public String register(@RequestParam(value="member_email") String member_email, @RequestParam(value="member_password") String member_password) {
        MemberDto memberDto = memberService.register(member_email,member_password);

        return memberDto.getMember_email() + memberDto.getMember_name() + memberDto.getMember_phone();
    }
    /*전체 검색*/
    @GetMapping(value = "/api/member/search")
    public List<MemberDto> search() {
        List<MemberDto> memberDtos = memberService.search();
        return memberDtos;
    }
}
