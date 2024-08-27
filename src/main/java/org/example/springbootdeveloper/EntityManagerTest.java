package org.example.springbootdeveloper;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityManagerTest {

        @Autowired
        EntityManager em;

        public void exmaple(){
            // 1) 엔티티 매니저가 엔티티를 관리하지 않는 상태(비영속 상태)
            // 엔티티를 처음 만들면 엔티티는 비영속 상태가 됨
            Member member = new Member(1L, "홍길동");

            //2) 엔티티가 관리되는 상태
            // persist() 메서드 사용해 엔티티를 관리 상태로 만들 수 있음
            // Member 객체는 영속성 컨텍스트에서 상태가 관리됨
            em.persist(member);

            //3) 엔티티 객체가 분리된 상태
            // 만약 엔티티를 영속성 컨텍스트에서 관리하고 싶지 않다면 detach() 메서드 사용해 분리상태로 만들 수 있음
            em.detach(member);

            // 4) 엔티티 객체가 삭제된 상태
            // 더 이상 객체가 필요 없다면 remove() 메서드 사용해서 엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제 가능
            em.remove(member);
        }

}
