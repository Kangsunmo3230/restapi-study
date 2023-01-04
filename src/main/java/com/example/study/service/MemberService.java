package com.example.study.service;


import com.example.study.dao.MemberDao;
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
    @Autowired
    MemberDao memberDao;


    public MemberDto register(String member_email, String member_password) {
        System.out.print("service");
            return memberDao.register(member_email,member_password);
    }


    public List<MemberDto> search() {
        return memberDao.search();
    }
}
