import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    // 4장 스프링부트3와 테스트

    // Junit은 테스트끼리 영향을 주지 않도록 각 테스트를 실행할때마다 테스트를 위한 실행 객체를 만들고
    // 테스트가 종료되면 실행 객체를 삭제

    @DisplayName("1+2는 3이다") // 테스트 이름
    @Test // 테스트를 수행하는 메서드
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;

        //assertEquals() : Junit에서 제공하는 검증 메서드
        // 첫번째 인수 : 기대하는값
        // 두번째 인수 : 실제로 검증할 값
        Assertions.assertEquals(sum, a+b);// 값이 같은 지 확인

    }

//    @DisplayName("1+3는 4이다") // 테스트 이름
//    @Test // 테스트를 수행하는 메서드
//    public void junitFailedTest(){
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(sum, a+b); // 실패하는 케이스
//
//    }
}
