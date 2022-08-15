package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>{

    Optional<Member> findById(int id);

    Optional<Member> findByName(String name);

    Optional<Member> findByMobilePhoneNumber(String mobilePhoneNumber);

}
