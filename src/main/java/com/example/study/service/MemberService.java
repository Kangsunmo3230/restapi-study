package com.example.study.service;


import com.example.study.dao.MemberDao;
import com.example.study.dto.LoginDto;
import com.example.study.dto.MemberDetailDto;
import com.example.study.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;

    public MemberDetailDto login(LoginDto loginDto) {
        MemberDto checkUser = memberDao.searchMemberByEmail(loginDto.getMemberEmail());


        if (passwordEncoder.matches(loginDto.getMemberPassword(), checkUser.getMemberPassword())) {
            MemberDetailDto loginUser = memberDao.login(loginDto);
            return loginUser;
        } else {
            return null;
        }

    }


    public List<MemberDto> search() {
        return memberDao.search();
    }

    public MemberDto searchMemberByEmail(String memberEmail) {
        return memberDao.searchMemberByEmail(memberEmail);
    }

    public void insert(MemberDto memberDto) {
        String enPw = passwordEncoder.encode(memberDto.getMemberPassword());
        memberDto.setMemberPassword(passwordEncoder.encode(memberDto.getMemberPassword()));
        memberDao.insert(memberDto);
    }
}
