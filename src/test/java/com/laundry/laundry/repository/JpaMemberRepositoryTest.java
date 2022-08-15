package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;
import com.laundry.laundry.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaMemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
     void 멤버등록_불러오기() {

        String name = "김성현"; //이름
        String mobilePhoneNumber = "010"; //핸드폰 전화
        String homePhoneNumber = "031"; //집전화
        String memo = "메모입니다"; //메모

        String compare_name = "안선영";

        //builder 클래스를 통해 생성자 생성 후 save (insert/update)
        memberRepository.saveMember(Member.builder()
                .name(name)
                .mobilePhoneNumber(mobilePhoneNumber)
                .homePhoneNumber(homePhoneNumber)
                .memo(memo)
                .build());

        List<Member> membersList = memberRepository.findAll();
        Member member = membersList.get(0);
        assertThat(member.getName()).isEqualTo(compare_name);
    }

    @Test
     void 이름으로_찾기() {

        Optional<Member> members = memberRepository.findByName("김성현");
        assertThat(members.get().getName()).isEqualTo("김성현");
    }

    @Test
    void findByPhoneNumber() {
        Optional<Member> members = memberRepository.findByPhoneNumber("010-7735-6068");
        assertThat(members.get().getName()).isEqualTo("안선영");
    }

    @Test
    void findByHomePhoneNumber() {
        Optional<Member> members = memberRepository.findByHomePhoneNumber("031");
        assertThat(members.get().getName()).isEqualTo("안선영");
    }

    @Test
    void findAll(){
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(8);
    }


    @Test
    void findById(){
        Optional<Member> member = memberRepository.findById(1);
        assertThat(member.get().getId()).isEqualTo(1);
        assertThat(member.get().getName()).isEqualTo("안선영");
    }
}