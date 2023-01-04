package com.example.study.dao;


import com.example.study.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
    MemberDto register(String member_email, String member_password);
    List<MemberDto> search();
}
