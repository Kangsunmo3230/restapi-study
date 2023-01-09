package com.example.study.controller;


import com.example.study.dao.MemberDao;
import com.example.study.dto.LoginDto;
import com.example.study.dto.MemberDetailDto;
import com.example.study.dto.MemberDto;
import com.example.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;




/*
 *   @Controller vs @RestController
 *
 *   @Controller는 View를 반환하기 위해 사용 됨.
 *   @RestController는 데이터를 Json 형태로 객체 데이터를 반환함.
 *
 * */

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    /*
     * ResponseEntity는 HttpEntity를 상속받고 사용자의 응답 데이터가 포함된 클래스 (HttpStatus , HttpHeaders, HttpBody)
     * http header에는 (요청/응답)에 대한 요구사항
     * http body에는 그내용
     * Response header 에는 웹서버가 웹브라우저에 응답하는 메시지가 들어있고, Reponse body에 데이터 값이 들어가있음.
     * */

    /*로그인*/
    @PostMapping(value = "/login")
    public ResponseEntity<MemberDetailDto> login(@Valid @RequestBody LoginDto loginDto) {

        MemberDetailDto memberDetailDto = memberService.login(loginDto);
        if (memberDetailDto != null) {
            return new ResponseEntity<MemberDetailDto>(memberDetailDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

    }

    /*회원 가입*/
    @PostMapping(value = "/insert")
    public void insert(@RequestBody MemberDto memberDto) {
        memberService.insert(memberDto);
    }


    /*전체 검색*/
    @GetMapping(value = "/search")
    public List<MemberDto> search() {
        List<MemberDto> memberDtos = memberService.search();
        return memberDtos;
    }

    /*이메일를 통해 검색*/
    @GetMapping(value = "/{memberEmail}")
    public MemberDto searchMemberByEmail(@PathVariable String memberEmail) {
        MemberDto memberDto = memberService.searchMemberByEmail(memberEmail);
        return memberDto;
    }


}
