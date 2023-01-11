package com.example.study;

import com.example.study.dao.MemberDao;
import com.example.study.dto.MemberDto;
import com.example.study.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;


//@RunWith(SpringJUnit4ClassRunner.class); Junit으로 실행하지 않고, 선언한 클래스로 진입점을 정의한다
 //MockMvc를 사용하기 위한 설정을 자동으로 주입해준다.(Rest 관련 어노테이션)
 //테스트 클래스임을 스프링에 알려준다.

@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@RequiredArgsConstructor
class StudyApplicationTests {
    private MemberService memberService;
   // private MockMvc mockMvc;

    private final MockMvc mockMvc;

    private PasswordEncoder passwordEncoder;

    private final ObjectMapper objectMapper;

    private final MemberDao memberDao;

    /*
    * 1.perfrom() : 요청을 전송하는 역할을 한다. 결과로 ResultaCTIONS 객체를 받으며, ResultActions 객체는 리턴 값을 검증하고
    * 확인할 수 있는 andExpect()메소드를 제공한다.
    * 2.get("/api/member/search") : http 메소드를 결정할 수 있다.(get/post/delete...)
    * 3.params(info) : 키 = 값의 파라미터를 전달할 수 있다. 여러개일 떄는 params() , 하나일떄는 param()을 사용한다.
    * 4.and Expect() : 응답을 검증하는 역할을 한다.
    *
    * */



    @Test
    @WithMockUser
    public void 멤버조회() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/member/search")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
                .characterEncoding(StandardCharsets.UTF_8.displayName());

        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print()) // 응답 데이터 출력
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

    }
    // 유저 추가 테스트
    @Test
    @WithMockUser
    public void 멤버추가() throws Exception {
        String enPw = passwordEncoder.encode("pass");
        MemberDto m = new MemberDto();
        m.setMemberPassword(enPw);
        m.setMemberEmail("test@naver.com");
        m.setMemberName("testName");
        m.setMemberPhone("010-1111-1111");
        m.setRegisterId(null);
        m.setModifyId(null);
        m.setRegisterDtm(null);
        m.setModifyDtm(null);
        m.setMemberSeq(100);

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/member/insert") // POST 요청
                                .accept(MediaType.APPLICATION_JSON)
                                .content(new ObjectMapper().writeValueAsString(m)) //Body 삽입
                )
                .andDo(MockMvcResultHandlers.print()); // 응답 데이터 출력
    }
}
