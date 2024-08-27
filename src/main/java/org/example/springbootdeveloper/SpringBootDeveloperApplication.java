package org.example.springbootdeveloper;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);

//        // 텍스트 블록
//        String query11 = "SELECT * FROM \"items\"\n" +
//                "WHERE \"status\" = \"ON_SALE\"\n" +
//                "ORDER BY \"price\";\n";
//
//        String query17 = """
//                SELECT * FROM "items"
//                WHERE "status" = "ON_SALE"
//                ORDER BY "price";
//                """;
//
//        System.out.println(query11);
//        System.out.println(query17);
//
//        // formatted()
//        String textBlock17 = """
//        {
//            "id" : %d,
//            "name" : %s
//        }
//        """.formatted(2, "juice");
//
//        System.out.println(textBlock17);
//
//        // 레코드
//        record Item(String name, int price) {
//            // 이렇게 하면 파라미터가 private final로 정의됨
//        }
//
//        Item juice = new Item("juice", 3000);
//        System.out.println(juice.price()); // 3000 출력
//
//        // 패턴 매칭 (instanceof)
//        Object o = 42;  // 예시로 `o`를 42로 정의
//        if (o instanceof Integer i) {
//            System.out.println("Integer value: " + i);
//        }
    }

    // 자료형에 맞는 case 처리
//    static double getIntegerValue(Object o) {
//        return switch (o) {
//            case Double d -> d.intValue();
//            case Float f -> f.intValue();
//            case String s -> Integer.parseInt(s);
//            default -> 0d;
//        };
//    }

}
