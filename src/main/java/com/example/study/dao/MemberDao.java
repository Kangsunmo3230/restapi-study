package com.example.study.dao;


import com.example.study.dto.LoginDto;
import com.example.study.dto.MemberDetailDto;
import com.example.study.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
    MemberDetailDto login(LoginDto loginDto);

    List<MemberDto> search();

    MemberDto searchMemberByEmail(String memberEmail);

    void insert(MemberDto memberDto);

    MemberDto getUser(String memberEmail);
}
