package com.example.study.controller;


import com.example.study.dao.MemberDao;
import com.example.study.dto.LoginDto;
import com.example.study.dto.MemberDto;
import com.example.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j

/*
 *   @Controller vs @RestController
 *
 *   @Controller는 View를 반환하기 위해 사용 됨.
 *   @RestController는 데이터를 Json 형태로 객체 데이터를 반환함.
 *
 * */

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/member")
public class MemberController {

    /**
     * private final vs private static final
     * private final 은 생성자를 통해 값을 참조할 수 있다. 객체 생성 시 초기화가 가능하다.
     * private static final은 생성자를 통해 참조할 수 없고 무조건 초기화돼있어야 함. => 해당 값을 바꾸지 않음
     */

    private final MemberService memberService;


    /*로그인*/
    @PostMapping(value = "/login")
    public MemberDto login(@RequestBody LoginDto loginDto) {
        log.info("loginDto ={}",loginDto);

        MemberDto memberDto = memberService.login(loginDto);
        log.info("memberDto ={}",memberDto);

        return memberDto;
    }

    /*회원 가입*/
    @PostMapping(value = "/insert")
    public void insert(@RequestBody MemberDto memberDto) {
        log.info("memberDto ={}", memberDto);
        memberService.insert(memberDto);
    }


    /*전체 검색*/
    @GetMapping(value = "/search")
    public List<MemberDto> search() {
        List<MemberDto> memberDtos = memberService.search();
        log.info("memberDtos =>{}", memberDtos);
        log.info("memberDtos=>{}", memberDtos.toString());
        return memberDtos;
    }

    /*이메일를 통해 검색*/
    @GetMapping(value = "/{memberEmail}")
    public MemberDto searchMemberByEmail(@PathVariable String memberEmail) {
        log.info("memberEmail ={}", memberEmail);
        MemberDto memberDto = memberService.searchMemberByEmail(memberEmail);
        log.info("memberDto ={}", memberDto);
        return memberDto;
    }


}
