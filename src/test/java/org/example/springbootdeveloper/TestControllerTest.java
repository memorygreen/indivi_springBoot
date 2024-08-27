//TestControllerTest.java

package org.example.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// 2단계
@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MocMvc 생성 및 자동 구성
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach // 테스트 실행 후 실행하는 메서드
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    // 3단계
    @DisplayName("getAllMembers : 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given : 멤버를 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when : 멤버 리스트를 조회하는 API를 호출
        final ResultActions result = mockMvc.perform(get(url)  // 1) perform() : 요청을 전송하는 역할을 하는 메서드 ->결과로 ResultActions 객체를 받음. (ResultActions 객체는 반환값을 검증하고 확인하는 andExpect() 메서드 제공
                .accept(MediaType.APPLICATION_JSON)); // 2) accept() : 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정하는 메서드 (JSON, XML... 다양! 여기서는 JSON받도록 명시)

        // then : 응답코드가 200 OK이고, 반환받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인
        result
                .andExpect(status().isOk()) //3) andExpect() : 응답을 검증함
                // ex. TestController에서 만든 API는 응답으로 OK(200)을 반환 -> 이에 해당하는 메서드인 isOk를 사용해 응답코드가 OK(200)인지 확인

                // 4) 응답의 0번째 값이 DB에 저장한 값과 같은지 확인
                // jsonPath("$[0].${필드명}") : JSON 응답값을 가져오는 역할을 하는 메서드
                // 0번째 배열에 들어있는 객체의 id, name값을 가져오고, 저장된 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }


}