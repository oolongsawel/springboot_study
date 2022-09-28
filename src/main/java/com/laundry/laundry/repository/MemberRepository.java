package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(int id);
    List<Member> findByName(String name);
    Optional<Member> findByMobilePhoneNumber(String phoneNumber);
    Optional<Member> findByHomePhoneNumber(String homePhoneNumber);
    List<Member> findByDelYnFalse();

    List<Member> findAll();

    void updateMemberInfo(int id , String name , String mobilePhoneNumber , String homePhoneNumber, String memo);

    void updateMemberDelYn(@Param("id")int id);
}
