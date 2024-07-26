package caffeinelil.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }


    @Sql("/insert-members.sql")
    @Test
    void getAllMembers() {
        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberByName(){
        //when
        Member member = memberRepository.findByname("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);
    }

    @Test
    void saveMember(){
        Member member = new Member(1L, "A");

        //when
        memberRepository.save(member);

        //then
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }

    @Test
    void saveMembers(){
        //given
        List<Member> members = List.of(new Member(2L, "B"),
                new Member(3L, "C"));

        memberRepository.saveAll(members);

        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @Test
    void deleteMemberById(){
        //when
        memberRepository.deleteById(2L);

        //then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    @Sql("/insert-members.sql")
    @Test
    void deleteAll(){
        //when
        memberRepository.deleteAll();

        //then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-members.sql")
    @Test
    void update(){
        //given
        Member member = memberRepository.findById(2L).get();

        //when
        member.changeName("BC");

        //then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }

    //원래 @Transactional 어노테이션을 붙여야 JPA가 변경 가지 기능을 통해 DB에 자동으로 변경사항을 반영한다.
    //하지만, 우린 이 테스트 코드에 @DataJpaTest 어노테이션을 사용하였기 때문에 자동 적용이 된다.
    //이게 뭔 개소리지 싶은데, @DataJpaTest 어노테이션의 세부 항목을 잘 보면, @Transactonal 어노테이션이 이미 있다! 두둥탁
    //앞으로는 @Transactional 어노테이션을 써야한다 맨이야~ 얘는!! @DataJpaTest만 쓰면 다 되는줄아냐구우웃!
}
