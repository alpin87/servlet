package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositotyTest {

    MemberRepositoty memberRepositoty = MemberRepositoty.getInstance();

    @AfterEach
    void afterEach(){
        memberRepositoty.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);

        Member savedMember = memberRepositoty.save(member);

        Member findMember = memberRepositoty.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("hello1", 20);
        Member member2 = new Member("hello2", 30);

        memberRepositoty.save(member1);
        memberRepositoty.save(member2);

        List<Member> result = memberRepositoty.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);

    }
}