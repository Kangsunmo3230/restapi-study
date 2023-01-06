package com.example.study.service;


import com.example.study.dao.MemberDao;
import com.example.study.dto.LoginDto;
import com.example.study.dto.MemberDetailDto;
import com.example.study.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public MemberDetailDto login(LoginDto loginDto) {
        return memberDao.login(loginDto);
    }


    public List<MemberDto> search() {
        return memberDao.search();
    }

    public MemberDto searchMemberByEmail(String memberEmail) {
        return memberDao.searchMemberByEmail(memberEmail);
    }

    public void insert(MemberDto memberDto) {
         memberDao.insert(memberDto);
    }
}
