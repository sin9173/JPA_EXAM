package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional //트랜젝션 처리 //테스트에 있을 경우 롤백
    @Rollback(false)
    public void testMember() throws Exception {
        //given
        MemberOld memberOld = new MemberOld();
        memberOld.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(memberOld);
        MemberOld findMemberOld = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMemberOld.getId()).isEqualTo(memberOld.getId());
        Assertions.assertThat(findMemberOld.getUsername()).isEqualTo(memberOld.getUsername());
        Assertions.assertThat(findMemberOld).isEqualTo(memberOld);
        System.out.println("findMember = " + findMemberOld);
        System.out.println("member = " + memberOld);
    }
}