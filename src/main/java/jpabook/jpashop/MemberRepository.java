package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;  //엔티티 메니저 주입

    public Long save(MemberOld memberOld) {
        em.persist(memberOld);
        return memberOld.getId();
    }

    public MemberOld find(Long id) {
        return em.find(MemberOld.class, id);
    }
}
