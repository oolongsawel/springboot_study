package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member saveMember(Member member);
    Member updateMember(Member member);
    Member deleteMember(Long id);

    Optional<Member> findById(int id);
    Optional<Member> findByName(String name);
    Optional<Member> findByPhoneNumber(String phoneNumber);
    Optional<Member> findByHomePhoneNumber(String homePhoneNumber);


    List<Member> findAll();
}
