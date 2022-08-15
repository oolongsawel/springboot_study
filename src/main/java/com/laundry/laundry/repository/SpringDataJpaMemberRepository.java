package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> , MemberRepository{

    Optional<Member> findById(int id);

    Optional<Member> findByName(String name);

    Optional<Member> findByMobilePhoneNumber(String mobilePhoneNumber);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Member m SET m.name = :name " +
            "and m.mobile_Phone_Number = :mobilePhoneNumber " +
            "and m.home_Phone_Number = :homePhoneNumber " +
            "and m.memo = :memo " +
            "where m.id = :id" , nativeQuery = true)
    int updateMemberInfo(@Param("id")int id , @Param("name") String name, @Param("mobilePhoneNumber") String mobilePhoneNumber
    ,@Param("homePhoneNumber") String homePhoneNumber, @Param("memo") String memo);


}
