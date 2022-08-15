package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(int id);
    Optional<Member> findByName(String name);
    Optional<Member> findByMobilePhoneNumber(String phoneNumber);
    Optional<Member> findByHomePhoneNumber(String homePhoneNumber);


    List<Member> findAll();

    int updateMemberInfo(int id , String name , String mobilePhoneNumber , String homePhoneNumber, String memo);
}
