package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> , MemberRepository{

    Optional<Member> findById(int id);

    List<Member> findByName(String name);

    Optional<Member> findByMobilePhoneNumber(String mobilePhoneNumber);

    List<Member> findByDelYnFalse();

    @Transactional
    @Modifying (clearAutomatically = true)
    @Query(value = "UPDATE Member m SET m.name = :name "+
            ", m.mobile_Phone_Number = :mobilePhoneNumber " +
            ", m.home_Phone_Number = :homePhoneNumber " +
            ", m.memo = :memo " +
            "where m.id = :id " ,nativeQuery = true)
    void updateMemberInfo( @Param("id")int id, @Param("name") String name, @Param("mobilePhoneNumber") String mobilePhoneNumber
    ,@Param("homePhoneNumber") String homePhoneNumber, @Param("memo") String memo);


    @Transactional
    @Modifying (clearAutomatically = true)
    @Query(value = "UPDATE Member m SET m.del_yn = TRUE "+
            "where m.id = :id " ,nativeQuery = true)
    void updateMemberDelYn( @Param("id")int id);

}
