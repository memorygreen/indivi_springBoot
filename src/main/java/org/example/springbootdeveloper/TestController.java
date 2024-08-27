// TestController.java 파일
package org.example.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

//    @GetMapping("/test")
//    public String test(){
//        return "Hello, world!";
//
//    }

    // 프레젠테이션 계층 - 컨트롤러 관련 코드
    @Autowired // testService 빈 주입
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }


}
