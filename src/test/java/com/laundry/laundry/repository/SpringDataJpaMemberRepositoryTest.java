package com.laundry.laundry.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SpringDataJpaMemberRepositoryTest {

    @Autowired
    SpringDataJpaMemberRepository memberRepository;

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByMobilePhoneNumber() {
    }

    @Test
    void updateMember() {
        //updateMember(String name, String mobilePhoneNumber , String homePhoneNumber, String memo)
        memberRepository.updateMemberInfo(1 , "안선영수정", "010" , "031" ,"메모임다");
    }
}