package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Member update(Member member);
    Member delete(Long id);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByPhoneNumber(String phoneNumber);

    List<Member> findAll();
}
