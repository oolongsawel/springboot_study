package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member saveMember(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member updateMember(Member member) {

        return null;
    }

    @Override
    public Member deleteMember(Long id) {
        return null;
    }

    @Override
    public Optional<Member> findById(int id) {
        Member member = em.find(Member.class, id);
        System.out.println(member);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPhoneNumber(String mobilePhoneNumber) {
        List<Member> result =  em.createQuery("select m from Member m where m.mobilePhoneNumber = :mobilePhoneNumber" , Member.class)
                .setParameter("mobilePhoneNumber", mobilePhoneNumber)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByHomePhoneNumber(String homePhoneNumber) {
        List<Member> result =  em.createQuery("select m from Member m where m.homePhoneNumber = :homePhoneNumber" , Member.class)
                .setParameter("homePhoneNumber", homePhoneNumber)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
